package kiryakova.cars.error;

import kiryakova.cars.common.ConstantsDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Грешка при запис на марка!")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BrandNotSavedException extends RuntimeException {
    private int statusCode;

    public BrandNotSavedException() {
        super(ConstantsDefinition.BrandConstants.BRAND_SAVE_ERROR);
        this.statusCode = 400;
    }

    public BrandNotSavedException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
