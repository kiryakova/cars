package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Model;
import kiryakova.cars.domain.models.service.ModelServiceModel;

public interface ModelValidationService {
    boolean isValid(Model model);

    boolean isValid(ModelServiceModel modelServiceModel);
}
