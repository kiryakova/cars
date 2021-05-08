package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OwnerNotSavedException extends RuntimeException {
    private int statusCode;

    public OwnerNotSavedException() {
        super(ConstantsDefinition.OwnerConstants.OWNER_SAVE_ERROR);
        this.statusCode = 400;
    }

    public OwnerNotSavedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
