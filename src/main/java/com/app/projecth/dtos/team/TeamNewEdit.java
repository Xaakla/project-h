package com.app.projecth.dtos.team;

import jakarta.validation.constraints.NotBlank;

public class TeamNewEdit {
    @NotBlank
    private String name;

    @NotBlank
    private String acronym;

    @NotBlank
    private String color;

    public TeamNewEdit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
