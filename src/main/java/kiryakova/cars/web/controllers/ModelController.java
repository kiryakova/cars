package kiryakova.cars.web.controllers;

import kiryakova.cars.domain.models.binding.ModelBindingModel;
import kiryakova.cars.domain.models.service.ModelServiceModel;
import kiryakova.cars.domain.models.view.ModelViewModel;
import kiryakova.cars.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(
            value = "/all/",
            params = { "brandId" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ModelViewModel> getModels(@RequestParam(name = "brandId", required = false) String brandId) {
        return this.modelService.findAllModels(brandId)
                .stream()
                .map(c -> this.modelMapper.map(c, ModelViewModel.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(
            value = "/",
            params = { "id" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModelViewModel getById(@RequestParam(name="id") String id) {
        ModelServiceModel modelServiceModel = this.modelService.findModelById(id);
        return this.modelMapper.map(modelServiceModel, ModelViewModel.class);
    }

    @PostMapping("/create")
    public ResponseEntity<ModelBindingModel> create(
            @Valid @RequestBody ModelBindingModel modelBindingModel) {

        ModelServiceModel modelServiceModel = this.modelMapper
                .map(modelBindingModel, ModelServiceModel.class);

        this.modelService.createModel(modelServiceModel);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ModelViewModel> deleteById(@PathVariable(name="id") String id) {
        this.modelService.deleteModel(id);
        return ResponseEntity.noContent().build();
    }

    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ObjectError> handleExceptionBadRequest(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return bindingResult.getAllErrors();
    }

}
