package kiryakova.cars.service;

import kiryakova.cars.common.ConstantsDefinition;
import kiryakova.cars.domain.entities.Car;
import kiryakova.cars.domain.entities.Model;
import kiryakova.cars.domain.entities.Owner;
import kiryakova.cars.domain.enums.EngineType;
import kiryakova.cars.domain.models.service.CarServiceModel;
import kiryakova.cars.domain.models.view.CarAllViewModel;
import kiryakova.cars.error.BindingModelFieldsException;
import kiryakova.cars.error.CarNotDeletedException;
import kiryakova.cars.error.CarNotFoundException;
import kiryakova.cars.error.CarNotSavedException;
import kiryakova.cars.repository.CarRepository;
import kiryakova.cars.validation.CarValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    //private final BrandService brandService;
    //private final ModelService modelService;
    //private final OwnerService ownerService;
    private final CarValidationService carValidation;
    private final ModelMapper modelMapper;

    @Autowired
    //public CarServiceImpl(CarRepository carRepository, BrandService brandService, ModelService modelService, OwnerService ownerService, CarValidationService carValidation, ModelMapper modelMapper) {
    public CarServiceImpl(CarRepository carRepository, CarValidationService carValidation, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        //this.brandService = brandService;
        //this.modelService = modelService;
        //this.ownerService = ownerService;
        this.carValidation = carValidation;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createCar(CarServiceModel carServiceModel) {
        if(!carValidation.isValid(carServiceModel)){
            throw new IllegalArgumentException();
        }

        carServiceModel.setRegNumber(carServiceModel.getRegNumber().toUpperCase());
        Car car = this.modelMapper.map(carServiceModel, Car.class);
        car.setEngineType(Enum.valueOf(EngineType.class, carServiceModel.getEngineType()));

        if(this.checkIfCarRegNumberAlreadyExists(car.getRegNumber())) {
            throw new CarNotSavedException(
                    String.format(
                            ConstantsDefinition.CarConstants.CAR_ALREADY_EXISTS,
                            car.getRegNumber())
            );
        }

        try {
            this.carRepository.saveAndFlush(car);
        } catch (Exception ignored){
            throw new CarNotSavedException(
                    String.format(
                            ConstantsDefinition.CarConstants.UNSUCCESSFUL_SAVED_CAR,
                            car.getRegNumber())
            );
        }
    }

    @Override
    public void updateCar(String id, CarServiceModel carServiceModel) {
        Car car = this.carRepository.findById(id).orElse(null);

        this.checkIfCarFound(car, carServiceModel.getRegNumber());

        try {
            car.setRegNumber(carServiceModel.getRegNumber().toUpperCase());
            car.setEngineVolume(carServiceModel.getEngineVolume());
            car.setEnginePower(carServiceModel.getEnginePower());
            car.setEngineType(Enum.valueOf(EngineType.class, carServiceModel.getEngineType()));
            car.setColor(carServiceModel.getColor());
            /*car.setBrand(this.modelMapper
                    .map(carServiceModel.getBrand(), Brand.class));*/
            car.setModel(this.modelMapper
                    .map(carServiceModel.getModel(), Model.class));
            car.setOwner(this.modelMapper
                    .map(carServiceModel.getOwner(), Owner.class));


            this.carRepository.save(car);
        } catch (Exception ignored){
            throw new CarNotSavedException(
                    String.format(
                            ConstantsDefinition.CarConstants.UNSUCCESSFUL_UPDATE_CAR,
                            car.getRegNumber())
            );
        }
    }

    @Override
    public void deleteCar(String id) {
        Car car = this.carRepository
                .findById(id).orElse(null);

        this.checkIfCarFound(car);

        try {
            this.carRepository.delete(car);
        }catch (Exception ignored){
            throw new CarNotDeletedException(
                    String.format(
                            ConstantsDefinition.CarConstants.UNSUCCESSFUL_DELETE_CAR,
                            car.getRegNumber())
            );
        }
    }

    @Override
    public CarServiceModel findCarById(String id) {
        Car car = this.carRepository
                .findById(id).orElse(null);

        this.checkIfCarFound(car);

        return this.modelMapper.map(car, CarServiceModel.class);
    }

    @Override
    public List<CarServiceModel> findAllCars(String brandId, String modelId) {

        if(!brandId.isEmpty() && !modelId.isEmpty()) {
            return this.carRepository.findAllByBrandIdAndModelId(brandId, modelId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, CarServiceModel.class))
                    .collect(Collectors.toList());
        }

        if(!brandId.isEmpty()){
            return this.carRepository.findAllByBrandId(brandId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, CarServiceModel.class))
                    .collect(Collectors.toList());
        }

        if(!modelId.isEmpty()) {
            return this.carRepository.findAllByModelId(modelId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, CarServiceModel.class))
                    .collect(Collectors.toList());
        }

        return this.carRepository.findAllCars()
                .stream()
                .map(p -> this.modelMapper.map(p, CarServiceModel.class))
                .collect(Collectors.toList());


    }

    /*@Override
    public List<ProductServiceModel> findAllProductsByCategoryIdAndProducerId(String categoryId,
                                                                              String producerId) {

        if((categoryId.equals("all") || categoryId.isEmpty())
                && (producerId.equals("all") || producerId.isEmpty())) {
            return this.findAllProducts()
                    .stream()
                    .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                    .collect(Collectors.toList());
        }

        if(producerId.equals("all") || producerId.isEmpty()) {
            return this.productRepository
                    .findAllByCategoryId(categoryId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                    .collect(Collectors.toList());
        }

        if(categoryId.equals("all") || categoryId.isEmpty()) {
            return this.productRepository
                    .findAllByProducerId(producerId)
                    .stream()
                    .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                    .collect(Collectors.toList());
        }

        return this.productRepository
                .findAllByCategoryIdAndProducerId(categoryId, producerId)
                .stream()
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .collect(Collectors.toList());
    }*/

    @Override
    public List<String> findEnumValues(String enumeration){
        EngineType[] engineTypes = EngineType.values();

        ArrayList<String> engineTypesList = new ArrayList<>();

        for (EngineType engineType : engineTypes) {
            engineTypesList.add(engineType.toString());
        }

        return engineTypesList;

    }

    @Override
    public boolean checkIfCarRegNumberAlreadyExists(String regNumber) {
        Car car = this.carRepository
                .findByRegNumber(regNumber).orElse(null);

        if(car == null) {
            return false;
        }

        return true;
    }

    private void checkIfCarFound(Car car) {
        if(!carValidation.isValid(car)) {
            throw new CarNotFoundException(ConstantsDefinition
                    .CarConstants.NO_SUCH_CAR);
        }
    }

    private void checkIfCarFound(Car car, String regNumber) {
        if(!carValidation.isValid(car)) {
            throw new CarNotFoundException(
                    String.format(
                            ConstantsDefinition.CarConstants.NO_CAR_WITH_REG_NUMBER,
                            regNumber)
            );
        }
    }
}
