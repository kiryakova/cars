package kiryakova.cars.domain.models.service;

public class BrandServiceModel extends BaseServiceModel {
    private String name;

    public BrandServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
