package com.aconex.hackathon.opendoor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    private String name;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
