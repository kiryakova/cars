package kiryakova.cars.service;

import kiryakova.cars.domain.models.service.ModelServiceModel;

import java.util.List;

public interface ModelService {
    void createModel(ModelServiceModel modelServiceModel);

    void updateModel(String id, ModelServiceModel modelServiceModel);

    void deleteModel(String id);

    ModelServiceModel findModelById(String id);

    List<ModelServiceModel> findAllModels(String brandId, String modelId);

    boolean checkIfModelNameAlreadyExists(String name);
}
