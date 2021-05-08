package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Model;
import kiryakova.cars.domain.models.service.ModelServiceModel;
import org.springframework.stereotype.Component;

@Component
public class ModelValidationServiceImpl implements ModelValidationService {
    @Override
    public boolean isValid(Model model) {
        return model != null;
    }

    @Override
    public boolean isValid(ModelServiceModel modelServiceModel) {
        return modelServiceModel != null;
    }
}
