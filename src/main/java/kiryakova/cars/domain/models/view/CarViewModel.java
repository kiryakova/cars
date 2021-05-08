package kiryakova.cars.domain.models.view;

public class CarViewModel extends BaseViewModel {

    private String regNumber;
    private Integer engineVolume;
    private Integer enginePower;
    private String engineType;
    private String color;
    //private BrandViewModel brand;
    private ModelViewModel model;
    private OwnerViewModel owner;

    public CarViewModel() {
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

/*    public BrandViewModel getBrand() {
        return brand;
    }

    public void setBrand(BrandViewModel brand) {
        this.brand = brand;
    }
*/
    public ModelViewModel getModel() {
        return model;
    }

    public void setModel(ModelViewModel model) {
        this.model = model;
    }

    public OwnerViewModel getOwner() {
        return owner;
    }

    public void setOwner(OwnerViewModel owner) {
        this.owner = owner;
    }
}
