package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CarNotDeletedException extends RuntimeException {
    private int statusCode;

    public CarNotDeletedException() {
        super(ConstantsDefinition.CarConstants.CAR_DELETE_ERROR);
        this.statusCode = 400;
    }

    public CarNotDeletedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
