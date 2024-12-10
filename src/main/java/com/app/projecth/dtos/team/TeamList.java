package com.app.projecth.dtos.team;

import com.app.projecth.database.entities.Team;

public class TeamList {

    private Long id;
    private String name;
    private String acronym;
    private String imageId;
    private String color;

    public TeamList() {
    }

    public TeamList(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.acronym = team.getAcronym();
        this.imageId = team.getImageId();
        this.color = team.getColor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
