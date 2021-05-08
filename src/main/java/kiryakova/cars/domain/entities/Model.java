package kiryakova.cars.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    private String name;
    private Brand brand;

    public Model() {
    }

    @Column(name = "model_name",nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
