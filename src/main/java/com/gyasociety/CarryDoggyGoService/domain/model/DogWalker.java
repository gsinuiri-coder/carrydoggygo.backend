package com.gyasociety.CarryDoggyGoService.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="dog_walkers")
public class DogWalker extends User {

    @Size(max = 300)
    private String description;

    @OneToMany(mappedBy = "dogWalker", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<WalkingSession> walkingSessions;

    //    ------------------------
    public String getDescription() {
        return description;
    }

    public DogWalker setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<WalkingSession> getWalkingSessions() {
        return walkingSessions;
    }

    public DogWalker setWalkingSessions(List<WalkingSession> walkingSessions) {
        this.walkingSessions = walkingSessions;
        return this;
    }
}