package kiryakova.cars.web.controllers;

import kiryakova.cars.domain.models.binding.BrandBindingModel;
import kiryakova.cars.domain.models.service.BrandServiceModel;
import kiryakova.cars.domain.models.view.BrandViewModel;
import kiryakova.cars.service.BrandService;
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
@RequestMapping("/brands")
public class BrandController extends BaseController {

    private final BrandService brandService;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    //@GetMapping("/all")
    @RequestMapping(
            value = "/all/",
            params = { "brandId" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<BrandViewModel> getBrands(@RequestParam(name = "brandId", required = false) String brandId) {
        return this.brandService.findAllBrands(brandId)
                .stream()
                .map(c -> this.modelMapper.map(c, BrandViewModel.class))
                .collect(Collectors.toList());
    }

    //@PostMapping("/create")
    @RequestMapping(
            value = "/create",
            params = { },
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BrandBindingModel> create(
            @Valid @RequestBody BrandBindingModel brandBindingModel,
            BindingResult bindingResult) {

        checkBindingModelErrors(bindingResult);

        BrandServiceModel brandServiceModel = this.modelMapper
                .map(brandBindingModel, BrandServiceModel.class);

        this.brandService.createBrand(brandServiceModel);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            value = "/update/",
            params = { "id" },
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BrandBindingModel> update(
            @RequestParam(name="id") String id,
            @Valid @RequestBody BrandBindingModel brandBindingModel,
            BindingResult bindingResult) {

        checkBindingModelErrors(bindingResult);

        BrandServiceModel brandServiceModel = this.modelMapper
                .map(brandBindingModel, BrandServiceModel.class);

        this.brandService.updateBrand(id, brandServiceModel);
        return ResponseEntity.ok().build();
    }

    //@DeleteMapping("/delete/{id}")
    //public ResponseEntity<BrandViewModel> deleteById(@PathVariable(name="id") String id) {
    @RequestMapping(
            value = "/delete/",
            params = { "id" },
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BrandViewModel> deleteById(@RequestParam(name="id") String id) {
        this.brandService.deleteBrand(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            value = "/",
            params = { "id" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BrandViewModel getById(@RequestParam(name="id") String id) {
        BrandServiceModel brandServiceModel = this.brandService.findBrandById(id);
        return this.modelMapper.map(brandServiceModel, BrandViewModel.class);
    }

    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ObjectError> handleExceptionBadRequest(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return bindingResult.getAllErrors();
    }

    /*@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ObjectError> handleExceptionNotFound(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return bindingResult.getAllErrors();
    }*/
}
