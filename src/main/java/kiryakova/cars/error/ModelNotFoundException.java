package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {
    private int statusCode;

    public ModelNotFoundException() {
        super(ConstantsDefinition.ModelConstants.NO_SUCH_MODEL);
        this.statusCode = 404;
    }

    public ModelNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
