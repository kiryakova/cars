package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ModelNotSavedException extends RuntimeException {
    private int statusCode;

    public ModelNotSavedException() {
        super(ConstantsDefinition.ModelConstants.MODEL_SAVE_ERROR);
        this.statusCode = 400;
    }

    public ModelNotSavedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
