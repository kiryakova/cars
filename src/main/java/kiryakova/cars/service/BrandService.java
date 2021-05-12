package kiryakova.cars.service;

import kiryakova.cars.domain.models.service.BrandServiceModel;

import java.util.List;

public interface BrandService {
    void createBrand(BrandServiceModel brandServiceModel);

    void updateBrand(String id, BrandServiceModel brandServiceModel);

    void deleteBrand(String id);

    BrandServiceModel findBrandById(String id);

    List<BrandServiceModel> findAllBrands();

    boolean checkIfBrandNameAlreadyExists(String name);
}
