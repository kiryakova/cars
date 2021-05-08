package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Owner;
import kiryakova.cars.domain.models.service.OwnerServiceModel;

public interface OwnerValidationService {
    boolean isValid(Owner owner);

    boolean isValid(OwnerServiceModel ownerServiceModel);
}
