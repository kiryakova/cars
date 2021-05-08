package kiryakova.cars.domain.models.binding;

import kiryakova.cars.common.ConstantsDefinition;
import kiryakova.cars.domain.entities.Brand;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModelBindingModel {

    private String name;
    private Brand brand;

    public ModelBindingModel() {
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @NotEmpty(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    @Length(min = 3, max = 25, message = ConstantsDefinition.BindingModelConstants.NAME_IS_NOT_CORRECT)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
