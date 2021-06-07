package com.gyasociety.CarryDoggyGoService.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="walk_status")
public class WalkStatus extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "walkStatus")
    @JsonIgnore
    private List<WalkingSession> walkingSessions;

    //---------------------------
    public Long getId() {
        return id;
    }

    public WalkStatus setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WalkStatus setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<WalkingSession> getWalkingSessions() {
        return walkingSessions;
    }

    public WalkStatus setWalkingSessions(List<WalkingSession> walkingSessions) {
        this.walkingSessions = walkingSessions;
        return this;
    }
}
