package com.vivid.partnerships.interview.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "venue")
public final class Venue extends SerialEntity {

    private String name;
    private String city;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
