package com.gyasociety.CarryDoggyGoService.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="locations")
public class Location extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String address;

    @Size(max = 50)
    private String numX;

    @Size(max = 50)
    private String numY;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "locations")
    @JsonIgnore
    private List<WalkingSession> walkingSessions;

    //------------------------------
    public Long getId() {
        return id;
    }

    public Location setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNumX() {
        return numX;
    }

    public Location setNumX(String numX) {
        this.numX = numX;
        return this;
    }

    public String getNumY() {
        return numY;
    }

    public Location setNumY(String numY) {
        this.numY = numY;
        return this;
    }

    public List<WalkingSession> getWalkingSessions() {
        return walkingSessions;
    }

    public Location setWalkingSessions(List<WalkingSession> walkingSessions) {
        this.walkingSessions = walkingSessions;
        return this;
    }
}
