package com.aconex.hackathon.opendoor.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int id;

    private String name;

    private String icon;

    private String shortDescription;

    private String fullDescription;

    public CategoryDto(int id, String name, String icon, String shortDescription, String fullDescription) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }

    public String getIcon() {
        return icon;
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
