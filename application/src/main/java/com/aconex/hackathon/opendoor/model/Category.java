package com.aconex.hackathon.opendoor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private int id;

    private String name;

    private String shortDescription;

    private String fullDescription;

    public Category() {
    }

    public Category(int id) {
        this.id = id;
    }

    public Category(int id, String name, String shortDescription, String fullDescription) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

}
