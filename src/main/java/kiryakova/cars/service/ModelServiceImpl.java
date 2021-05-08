package kiryakova.cars.service;

import kiryakova.cars.common.ConstantsDefinition;
import kiryakova.cars.domain.entities.Brand;
import kiryakova.cars.domain.entities.Model;
import kiryakova.cars.domain.models.service.CarServiceModel;
import kiryakova.cars.domain.models.service.ModelServiceModel;
import kiryakova.cars.error.ModelNotDeletedException;
import kiryakova.cars.error.ModelNotFoundException;
import kiryakova.cars.error.ModelNotSavedException;
import kiryakova.cars.repository.ModelRepository;
import kiryakova.cars.validation.ModelValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelValidationService modelValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelValidationService modelValidation, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelValidation = modelValidation;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createModel(ModelServiceModel modelServiceModel) {
        if(!modelValidation.isValid(modelServiceModel)){
            throw new IllegalArgumentException();
        }

        Model model = this.modelMapper.map(modelServiceModel, Model.class);

        if(this.checkIfModelNameAlreadyExists(model.getName())) {
            throw new ModelNotSavedException(
                    String.format(
                            ConstantsDefinition.ModelConstants.MODEL_ALREADY_EXISTS,
                            model.getName())
            );
        }

        try {
            this.modelRepository.saveAndFlush(model);
        } catch (Exception ignored){
            throw new ModelNotSavedException(
                    String.format(
                            ConstantsDefinition.ModelConstants.UNSUCCESSFUL_SAVED_MODEL,
                            model.getName())
            );
        }
    }

    @Override
    public void updateModel(String id, ModelServiceModel modelServiceModel) {
        Model model = this.modelRepository.findById(id).orElse(null);

        this.checkIfModelFound(model, modelServiceModel.getName());

        model.setName(modelServiceModel.getName());
        model.setBrand(this.modelMapper
                .map(modelServiceModel.getBrand(), Brand.class));

        try {
            this.modelRepository.save(model);
        } catch (Exception ignored){
            throw new ModelNotSavedException(
                    String.format(
                            ConstantsDefinition.ModelConstants.UNSUCCESSFUL_SAVED_MODEL,
                            model.getName())
            );
        }
    }

    @Override
    public void deleteModel(String id) {
        Model model = this.modelRepository
                .findById(id).orElse(null);

        this.checkIfModelFound(model);

        try {
            this.modelRepository.delete(model);
        }catch (Exception ignored){
            throw new ModelNotDeletedException(
                    String.format(
                            ConstantsDefinition.ModelConstants.UNSUCCESSFUL_DELETE_MODEL,
                            model.getName())
            );
        }
    }

    @Override
    public ModelServiceModel findModelById(String id) {
        Model model = this.modelRepository
                .findById(id).orElse(null);

        this.checkIfModelFound(model);

        return this.modelMapper.map(model, ModelServiceModel.class);
    }

    @Override
    public List<ModelServiceModel> findAllModels(String brandId, String modelId) {
        if(!brandId.isEmpty() && !modelId.isEmpty()) {
            return this.modelRepository.findAllByBrandIdAndModelId(brandId, modelId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, ModelServiceModel.class))
                    .collect(Collectors.toList());
        }

        if(!brandId.isEmpty()) {
            return this.modelRepository.findAllModelsByBrandId(brandId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, ModelServiceModel.class))
                    .collect(Collectors.toList());
        }

        if(!modelId.isEmpty()) {
            return this.modelRepository.findAllModelsByModelId(modelId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, ModelServiceModel.class))
                    .collect(Collectors.toList());
        }

        return this.modelRepository.findAllModels()
                .stream()
                .map(p -> this.modelMapper.map(p, ModelServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkIfModelNameAlreadyExists(String name) {
        Model model = this.modelRepository
                .findByName(name).orElse(null);

        if(model == null) {
            return false;
        }

        return true;
    }

    private void checkIfModelFound(Model model) {
        if(!modelValidation.isValid(model)) {
            throw new ModelNotFoundException(ConstantsDefinition
                    .ModelConstants.NO_SUCH_MODEL);
        }
    }

    private void checkIfModelFound(Model model, String name) {
        if(!modelValidation.isValid(model)) {
            throw new ModelNotFoundException(
                    String.format(
                            ConstantsDefinition.ModelConstants.NO_MODEL_WITH_NAME,
                            name)
            );
        }
    }
}
