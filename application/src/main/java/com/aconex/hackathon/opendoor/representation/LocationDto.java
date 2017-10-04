package com.aconex.hackathon.opendoor.representation;

public class LocationDto {

    private int id;
    private String name;

    public LocationDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
