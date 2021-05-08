package kiryakova.cars.web.controllers;

import kiryakova.cars.domain.models.binding.CarBindingModel;
import kiryakova.cars.domain.models.service.CarServiceModel;
import kiryakova.cars.domain.models.view.CarAllViewModel;
import kiryakova.cars.domain.models.view.CarViewModel;
import kiryakova.cars.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController extends BaseController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    @Autowired
    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    //@GetMapping("/all")
    //@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)

    @RequestMapping(
            value = "/all/",
            params = { "brandId", "modelId" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CarAllViewModel> getAll(@RequestParam(name = "brandId", required = false) String brandId,
                                        @RequestParam(name = "modelId", required = false) String modelId) {
        return this.carService.findAllCars(brandId, modelId)
                .stream()
                .map(c -> this.modelMapper.map(c, CarAllViewModel.class))
                .collect(Collectors.toList());
    }

    /*@GetMapping("/car/{id}")
    public ResponseEntity<CarViewModel> getById(@PathVariable(name="id") String id) {
        CarServiceModel carServiceModel = this.carService.findCarById(id);
        return ResponseEntity.ok(this.modelMapper.map(carServiceModel, CarViewModel.class));
    }*/

    @RequestMapping(
            value = "/",
            params = { "id" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CarViewModel getById(@RequestParam(name="id") String id) {
        CarServiceModel carServiceModel = this.carService.findCarById(id);
        return this.modelMapper.map(carServiceModel, CarViewModel.class);
    }

    //@PostMapping("/create")
    @RequestMapping(
            value = "/create",
            params = { },
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CarBindingModel> create(
            @Valid @RequestBody CarBindingModel carBindingModel,
            BindingResult bindingResult) {

        checkBindingModelErrors(bindingResult);

        CarServiceModel carServiceModel = this.modelMapper
                .map(carBindingModel, CarServiceModel.class);

        this.carService.createCar(carServiceModel);

        return ResponseEntity.ok().build();
    }

    //@PutMapping("/update/{id}")
    @RequestMapping(
            value = "/update/",
            params = { "id" },
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CarBindingModel> update(
            @RequestParam(name="id") String id,
            @Valid @RequestBody CarBindingModel carBindingModel,
            BindingResult bindingResult) {

        checkBindingModelErrors(bindingResult);

        CarServiceModel carServiceModel = this.modelMapper
                .map(carBindingModel, CarServiceModel.class);

        this.carService.updateCar(id, carServiceModel);
        return ResponseEntity.ok().build();
    }

    //@DeleteMapping("/delete/{id}")
    //public ResponseEntity<CarViewModel> deleteById(@PathVariable(name="id") String id) {
    @RequestMapping(
            value = "/delete/",
            params = { "id" },
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CarViewModel> deleteById(@RequestParam(name="id") String id) {
        this.carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ObjectError> handleExceptionBadRequest(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return bindingResult.getAllErrors();
    }

    @RequestMapping(
            value = "/",
            params = { "enumeration" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getEnumValues(@RequestParam(name = "enumeration") String enumeration) {
        return this.carService.findEnumValues(enumeration);
    }

    /*
        private void checkBindingModelErrors(CarBindingModel carBindingModel, BindingResult bindingResult) {
        List<FieldError> errors;
        List<String> message = new ArrayList<>();
          if(carBindingModel.getModel() == null){
            bindingResult.addError(new FieldError("carBindingModel", "model",
                    ConstantsDefinition.BindingModelConstants.NOT_EMPTY));
        }

        if(carBindingModel.getOwner() == null){
            bindingResult.addError(new FieldError("carBindingModel", "owner",
                    ConstantsDefinition.BindingModelConstants.NOT_EMPTY));
        }
    */
}
