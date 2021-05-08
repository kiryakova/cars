package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CarNotSavedException extends RuntimeException {
    private int statusCode;

    public CarNotSavedException() {
        super(ConstantsDefinition.CarConstants.CAR_SAVE_ERROR);
        this.statusCode = 400;
    }

    public CarNotSavedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
