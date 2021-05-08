package kiryakova.cars.service;

import kiryakova.cars.domain.models.service.CarServiceModel;

import java.util.List;

public interface CarService {
    void createCar(CarServiceModel carServiceModel);

    void updateCar(String id, CarServiceModel carServiceModel);

    void deleteCar(String id);

    CarServiceModel findCarById(String id);

    List<CarServiceModel> findAllCars(String brandId, String modelId);

    List<String> findEnumValues(String enumeration);

    boolean checkIfCarRegNumberAlreadyExists(String regNumber);
}
