package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Грешка при изтриване на модел!")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ModelNotDeletedException extends RuntimeException {
    private int statusCode;

    public ModelNotDeletedException() {
        super(ConstantsDefinition.ModelConstants.MODEL_DELETE_ERROR);
        this.statusCode = 400;
    }

    public ModelNotDeletedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
