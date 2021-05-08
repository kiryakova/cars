package kiryakova.cars.web.controllers;

import kiryakova.cars.domain.models.binding.OwnerBindingModel;
import kiryakova.cars.domain.models.service.OwnerServiceModel;
import kiryakova.cars.domain.models.view.OwnerViewModel;
import kiryakova.cars.service.OwnerService;
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
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    @Autowired
    public OwnerController(OwnerService ownerService, ModelMapper modelMapper) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<OwnerViewModel> getOwners() {
        return this.ownerService.findAllOwners()
                .stream()
                .map(c -> this.modelMapper.map(c, OwnerViewModel.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(
            value = "/",
            params = { "id" },
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OwnerViewModel getById(@RequestParam(name="id") String id) {
        OwnerServiceModel ownerServiceModel = this.ownerService.findOwnerById(id);
        return this.modelMapper.map(ownerServiceModel, OwnerViewModel.class);
    }

    @PostMapping("/create")
    public ResponseEntity<OwnerBindingModel> create(
            @Valid @RequestBody OwnerBindingModel ownerBindingModel) {

        OwnerServiceModel ownerServiceModel = this.modelMapper
                .map(ownerBindingModel, OwnerServiceModel.class);

        this.ownerService.createOwner(ownerServiceModel);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OwnerBindingModel> update(
            @PathVariable(name="id") String id,
            @Valid @RequestBody OwnerBindingModel ownerBindingModel) {

        OwnerServiceModel ownerServiceModel = this.modelMapper
                .map(ownerBindingModel, OwnerServiceModel.class);

        this.ownerService.updateOwner(id, ownerServiceModel);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OwnerViewModel> deleteById(@PathVariable(name="id") String id) {
        this.ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }

    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ObjectError> handleExceptionBadRequest(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return bindingResult.getAllErrors();
    }
}
