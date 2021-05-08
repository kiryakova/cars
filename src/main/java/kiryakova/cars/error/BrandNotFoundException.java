package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Марката не е намерена!")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BrandNotFoundException extends RuntimeException {
    private int statusCode;

    public BrandNotFoundException() {
        super(ConstantsDefinition.BrandConstants.NO_SUCH_BRAND);
        this.statusCode = 404;
    }

    public BrandNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
