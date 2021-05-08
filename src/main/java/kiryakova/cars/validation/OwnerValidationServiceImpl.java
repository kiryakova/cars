package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Owner;
import kiryakova.cars.domain.models.service.OwnerServiceModel;
import org.springframework.stereotype.Component;

@Component
public class OwnerValidationServiceImpl implements OwnerValidationService {
    @Override
    public boolean isValid(Owner owner) {
        return owner != null;
    }

    @Override
    public boolean isValid(OwnerServiceModel ownerServiceModel) {
        return ownerServiceModel != null;
    }
}
