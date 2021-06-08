package com.gyasociety.CarryDoggyGoService.resource;

import com.gyasociety.CarryDoggyGoService.domain.model.AuditModel;
import com.gyasociety.CarryDoggyGoService.domain.model.DogOwner;

public class DogResource extends AuditModel {

    private Long id;
    private String name;
    private String race;
    private String description;
    private DogOwner dogOwner;

    public Long getId() {
        return id;
    }

    public DogResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getRace() {
        return race;
    }

    public DogResource setRace(String race) {
        this.race = race;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DogResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public DogOwner getDogOwner() {
        return dogOwner;
    }

    public DogResource setDogOwner(DogOwner dogOwner) {
        this.dogOwner = dogOwner;
        return this;
    }
}
