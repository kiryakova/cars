package kiryakova.cars.domain.models.binding;

import kiryakova.cars.domain.entities.Model;
import kiryakova.cars.domain.entities.Owner;

import kiryakova.cars.common.ConstantsDefinition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class CarBindingModel {

    private String regNumber;
    private Integer engineVolume;
    private Integer enginePower;
    private String engineType;
    private String color;
    private Model model;
    private Owner owner;

    public CarBindingModel() {
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @NotEmpty(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    @Pattern(regexp = "^([a-z,A-Z]{1,2})*([ ]{1})*([0-9]{4,6})([ ]{1})*([a-z,A-Z]{2})*$",
            message = ConstantsDefinition.BindingModelConstants.REG_NUMBER_IS_NOT_CORRECT)
    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @Positive(message = ConstantsDefinition.BindingModelConstants.VALUE_SHOULD_BE_POSITIVE)
    @Max(value=9000, message = ConstantsDefinition.BindingModelConstants.VALUE_SHOULD_BE_EQUAL_OR_LESS_THAN)
    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @Positive(message = ConstantsDefinition.BindingModelConstants.VALUE_SHOULD_BE_POSITIVE)
    @Max(value=9000, message = ConstantsDefinition.BindingModelConstants.VALUE_SHOULD_BE_EQUAL_OR_LESS_THAN)
    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @NotEmpty(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_NULL)
    @NotEmpty(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    @Length(min = 3, max = 12, message = ConstantsDefinition.BindingModelConstants.COLOR_IS_NOT_CORRECT)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @NotNull(message = ConstantsDefinition.BindingModelConstants.NOT_EMPTY)
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
