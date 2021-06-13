package com.gyasociety.carrydoggygoservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reports")
public class Report extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "walking_session_id", nullable = false)
    @JsonIgnore
    private WalkingSession walkingSession;

    public Long getId() {
        return id;
    }

    public Report setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Report setDescription(String description) {
        this.description = description;
        return this;
    }

    public WalkingSession getWalkingSession() {
        return walkingSession;
    }

    public Report setWalkingSession(WalkingSession walkingSession) {
        this.walkingSession = walkingSession;
        return this;
    }
}
