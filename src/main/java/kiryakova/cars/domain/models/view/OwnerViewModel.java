package kiryakova.cars.domain.models.view;

public class OwnerViewModel extends BaseViewModel {

    private String firstName;
    private String lastName;
    private Long egn;
    private String address;
    private String phone;

    public OwnerViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEgn() {
        return egn;
    }

    public void setEgn(Long egn) {
        this.egn = egn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
