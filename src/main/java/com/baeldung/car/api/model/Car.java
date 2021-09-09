package com.baeldung.car.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
public class Car  implements Serializable {
    private @Id long id;
    private String brand;
    private String model;
    private String color;
    private String fuel;
    private int year;

    public Car(String brand, String model, String color, String fuel, int year) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuel = fuel;
        this.year = year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}