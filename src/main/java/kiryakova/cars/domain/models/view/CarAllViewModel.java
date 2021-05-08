package kiryakova.cars.domain.models.view;

public class CarAllViewModel extends BaseViewModel {

    private String regNumber;
    private ModelViewModel model;

    public CarAllViewModel() {
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public ModelViewModel getModel() {
        return model;
    }

    public void setModel(ModelViewModel model) {
        this.model = model;
    }
}
