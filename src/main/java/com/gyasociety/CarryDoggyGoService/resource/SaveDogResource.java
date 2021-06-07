package com.gyasociety.CarryDoggyGoService.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveDogResource {

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String race;

    @NotNull
    @Size(max = 100)
    private String description;

    public String getName() {
        return name;
    }

    public SaveDogResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getRace() {
        return race;
    }

    public SaveDogResource setRace(String race) {
        this.race = race;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveDogResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
