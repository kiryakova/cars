package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Car;
import kiryakova.cars.domain.models.service.CarServiceModel;
import org.springframework.stereotype.Component;

@Component
public class CarValidationServiceImpl implements CarValidationService {
    @Override
    public boolean isValid(Car car) {
        return car != null;
    }

    @Override
    public boolean isValid(CarServiceModel carServiceModel) {
        return carServiceModel != null;
    }
}
