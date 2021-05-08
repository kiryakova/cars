package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {
    private int statusCode;

    public OwnerNotFoundException() {
        super(ConstantsDefinition.OwnerConstants.NO_SUCH_OWNER);
        this.statusCode = 404;
    }

    public OwnerNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
