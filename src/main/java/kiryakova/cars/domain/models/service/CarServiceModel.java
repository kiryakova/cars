package kiryakova.cars.domain.models.service;

public class CarServiceModel extends BaseServiceModel {

    private String regNumber;
    private Integer engineVolume;
    private Integer enginePower;
    private String engineType;
    private String color;
    //private BrandServiceModel brand;
    private ModelServiceModel model;
    private OwnerServiceModel owner;

    public CarServiceModel() {
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

/*    public BrandServiceModel getBrand() {
        return brand;
    }

    public void setBrand(BrandServiceModel brand) {
        this.brand = brand;
    }
*/
    public ModelServiceModel getModel() {
        return model;
    }

    public void setModel(ModelServiceModel model) {
        this.model = model;
    }

    public OwnerServiceModel getOwner() {
        return owner;
    }

    public void setOwner(OwnerServiceModel owner) {
        this.owner = owner;
    }
}
