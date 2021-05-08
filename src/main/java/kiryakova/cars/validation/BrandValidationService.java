package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Brand;
import kiryakova.cars.domain.models.service.BrandServiceModel;

public interface BrandValidationService {
    boolean isValid(Brand brand);

    boolean isValid(BrandServiceModel brandServiceModel);
}
