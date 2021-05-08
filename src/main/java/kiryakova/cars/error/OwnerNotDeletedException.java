package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OwnerNotDeletedException extends RuntimeException {
    private int statusCode;

    public OwnerNotDeletedException() {
        super(ConstantsDefinition.OwnerConstants.OWNER_DELETE_ERROR);
        this.statusCode = 400;
    }

    public OwnerNotDeletedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
