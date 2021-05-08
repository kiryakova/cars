package kiryakova.cars.web.controllers;

import kiryakova.cars.error.BindingModelFieldsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseController {
    protected void checkBindingModelErrors(BindingResult bindingResult) {
        List<FieldError> errors;
        List<String> message = new ArrayList<>();

        if (bindingResult.hasErrors()) {
            errors = bindingResult.getFieldErrors();

            for (FieldError e : errors){
                message.add(e.getField() + ":" + e.getDefaultMessage());
            }

            throw new BindingModelFieldsException(message);
        }
    }
}
