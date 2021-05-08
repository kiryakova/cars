package kiryakova.cars.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BindingModelFieldsException extends RuntimeException {
    private int statusCode;
    //private List<FieldError> bindingResult;

    public BindingModelFieldsException(List<String> message) {
        super(message.toString());
        this.statusCode = 400;
        //this.bindingResult = bindingResult.getFieldErrors();
    }

    public int getStatusCode() {
        return statusCode;
    }
}
