package com.vehicle.workshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Franchise extends BaseEntity {

    @Id
    private Long id;

    private String name;

    private Float tax;

    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
