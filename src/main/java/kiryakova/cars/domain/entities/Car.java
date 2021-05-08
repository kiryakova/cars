package kiryakova.cars.domain.entities;

import kiryakova.cars.domain.enums.EngineType;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car extends BaseEntity {

    private String regNumber;
    private Integer engineVolume;
    private Integer enginePower;
    private EngineType engineType;
    private String color;
    //private Brand brand;
    private Model model;
    private Owner owner;

    public Car() {
    }

    @Column(name = "reg_number", nullable = false, unique = true)
    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Column(name = "engine_volume", nullable = false)
    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Column(name = "engine_power", nullable = false)
    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type", nullable = false)
    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Column(name = "color", nullable = false)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

/*    @OneToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
*/

    @OneToOne(targetEntity = Model.class)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
