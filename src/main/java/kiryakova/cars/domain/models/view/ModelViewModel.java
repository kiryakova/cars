package kiryakova.cars.domain.models.view;

import kiryakova.cars.domain.entities.Brand;

public class ModelViewModel extends BaseViewModel {
    private String name;
    private Brand brand;

    public ModelViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
