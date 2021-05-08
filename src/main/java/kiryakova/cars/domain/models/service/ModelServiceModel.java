package kiryakova.cars.domain.models.service;

import kiryakova.cars.common.ConstantsDefinition;
import org.hibernate.validator.constraints.Length;

public class ModelServiceModel extends BaseServiceModel {

    private String name;
    private BrandServiceModel brand;

    public ModelServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandServiceModel getBrand() {
        return brand;
    }

    public void setBrand(BrandServiceModel brand) {
        this.brand = brand;
    }
}
