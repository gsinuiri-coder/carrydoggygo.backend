package com.gyasociety.CarryDoggyGoService.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="qualifications")
public class Qualification extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Byte star;

    //    -----------------------
    public Long getId() {
        return id;
    }

    public Qualification setId(Long id) {
        this.id = id;
        return this;
    }

    public Byte getStar() {
        return star;
    }

    public Qualification setStar(Byte star) {
        this.star = star;
        return this;
    }
}
