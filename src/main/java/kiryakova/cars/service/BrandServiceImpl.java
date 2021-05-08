package kiryakova.cars.service;

import kiryakova.cars.common.ConstantsDefinition;
import kiryakova.cars.domain.entities.Brand;
import kiryakova.cars.domain.models.service.BrandServiceModel;
import kiryakova.cars.error.BrandNotDeletedException;
import kiryakova.cars.error.BrandNotFoundException;
import kiryakova.cars.error.BrandNotSavedException;
import kiryakova.cars.repository.BrandRepository;
import kiryakova.cars.validation.BrandValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandValidationService brandValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository,
                            BrandValidationService brandValidation,
                            ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.brandValidation = brandValidation;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createBrand(BrandServiceModel brandServiceModel) {
        if(!brandValidation.isValid(brandServiceModel)){
            throw new IllegalArgumentException();
        }

        Brand brand = this.modelMapper.map(brandServiceModel, Brand.class);

        if(this.checkIfBrandNameAlreadyExists(brand.getName())) {
            throw new BrandNotSavedException(
                    String.format(
                            ConstantsDefinition.BrandConstants.BRAND_ALREADY_EXISTS,
                            brand.getName())
            );
        }

        try {
            this.brandRepository.save(brand);
        } catch (Exception ignored){
            throw new BrandNotSavedException(
                    String.format(
                            ConstantsDefinition.BrandConstants.UNSUCCESSFUL_SAVED_BRAND,
                            brand.getName())
            );
        }
    }

    @Override
    public void updateBrand(String id, BrandServiceModel brandServiceModel) {
        Brand brand = this.brandRepository.findById(id).orElse(null);

        this.checkIfBrandFound(brand, brandServiceModel.getName());

        brand.setName(brandServiceModel.getName());

        try {
            this.brandRepository.save(brand);
        } catch (Exception ignored){
            throw new BrandNotSavedException(
                    String.format(
                            ConstantsDefinition.BrandConstants.UNSUCCESSFUL_SAVED_BRAND,
                            brand.getName())
            );
        }
    }

    @Override
    public void deleteBrand(String id) {
        Brand brand = this.brandRepository
                .findById(id).orElse(null);

        this.checkIfBrandFound(brand);

        try {
            this.brandRepository.delete(brand);
        }catch (Exception ignored){
            throw new BrandNotDeletedException(
                    String.format(
                            ConstantsDefinition.BrandConstants.UNSUCCESSFUL_DELETE_BRAND,
                            brand.getName())
            );
        }
    }

    @Override
    public BrandServiceModel findBrandById(String id) {
        Brand brand = this.brandRepository
                .findById(id).orElse(null);

        this.checkIfBrandFound(brand);

        return this.modelMapper.map(brand, BrandServiceModel.class);
    }

    @Override
    public List<BrandServiceModel> findAllBrands(String brandId) {
        if(!brandId.isEmpty()) {
            return this.brandRepository.findAllBrandsByBrandId(brandId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, BrandServiceModel.class))
                    .collect(Collectors.toList());
        }

        return this.brandRepository.findAllBrands()
                .stream()
                .map(p -> this.modelMapper.map(p, BrandServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkIfBrandNameAlreadyExists(String name) {
        Brand brand = this.brandRepository
                .findByName(name).orElse(null);

        if(brand == null) {
            return false;
        }

        return true;
    }

    private void checkIfBrandFound(Brand brand) {
        if(!brandValidation.isValid(brand)) {
            throw new BrandNotFoundException(ConstantsDefinition
                    .BrandConstants.NO_SUCH_BRAND);
        }
    }

    private void checkIfBrandFound(Brand brand, String name) {
        if(!brandValidation.isValid(brand)) {
            throw new BrandNotFoundException(
                    String.format(
                            ConstantsDefinition.BrandConstants.NO_BRAND_WITH_NAME,
                            name)
            );
        }
    }
}
