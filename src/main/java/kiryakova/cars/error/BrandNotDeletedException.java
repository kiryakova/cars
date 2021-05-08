package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Грешка при изтриване на марка!")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BrandNotDeletedException extends RuntimeException {
    private int statusCode;

    public BrandNotDeletedException() {
        super(ConstantsDefinition.BrandConstants.BRAND_DELETE_ERROR);
        this.statusCode = 400;
    }

    public BrandNotDeletedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
