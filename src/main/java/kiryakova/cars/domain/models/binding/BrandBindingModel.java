package kiryakova.cars.domain.models.binding;

import kiryakova.cars.common.ConstantsDefinition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BrandBindingModel {
    private String name;

    public BrandBindingModel() {
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @NotEmpty(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    @Length(min = 2, max = 25, message = ConstantsDefinition.BindingModelConstants.NAME_IS_NOT_CORRECT)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
