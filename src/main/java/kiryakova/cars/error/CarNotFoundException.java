package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {
    private int statusCode;

    public CarNotFoundException() {
        super(ConstantsDefinition.CarConstants.NO_SUCH_CAR);
        this.statusCode = 404;
    }

    public CarNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
