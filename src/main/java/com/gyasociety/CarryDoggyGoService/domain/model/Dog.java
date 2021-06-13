package com.gyasociety.carrydoggygoservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="dogs")
public class Dog extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String race;

    @NotNull
    @Size(max = 100)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dog_owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DogOwner dogOwner;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "dogs")
    @JsonIgnore
    private List<WalkingSession> walkingSessions;

    public Long getId() {
        return id;
    }

    public Dog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public String getRace() {
        return race;
    }

    public Dog setRace(String race) {
        this.race = race;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Dog setDescription(String description) {
        this.description = description;
        return this;
    }

    public DogOwner getDogOwner() {
        return dogOwner;
    }

    public Dog setDogOwner(DogOwner dogOwner) {
        this.dogOwner = dogOwner;
        return this;
    }

    public List<WalkingSession> getWalkingSessions() {
        return walkingSessions;
    }

    public Dog setWalkingSessions(List<WalkingSession> walkingSessions) {
        this.walkingSessions = walkingSessions;
        return this;
    }
}
