package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Brand;
import kiryakova.cars.domain.models.service.BrandServiceModel;
import org.springframework.stereotype.Component;

@Component
public class BrandValidationServiceImpl implements BrandValidationService {
    @Override
    public boolean isValid(Brand brand) {
        return brand != null;
    }

    @Override
    public boolean isValid(BrandServiceModel brandServiceModel) {
        return brandServiceModel != null;
    }
}