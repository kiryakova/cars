package kiryakova.cars.validation;

import kiryakova.cars.domain.entities.Car;
import kiryakova.cars.domain.models.service.CarServiceModel;

public interface CarValidationService {
    boolean isValid(Car car);

    boolean isValid(CarServiceModel carServiceModel);
}
