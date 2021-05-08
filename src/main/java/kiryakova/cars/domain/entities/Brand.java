package kiryakova.cars.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;
    private List<Model> models;

    public Brand() {
        //this.models = new ArrayList<>();
    }

    @Column(name = "brand_name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
