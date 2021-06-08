package com.gyasociety.CarryDoggyGoService.resource;

import com.gyasociety.CarryDoggyGoService.domain.model.AuditModel;

import java.util.Date;

public class WalkingSessionResource extends AuditModel {

    private Long id;
    private Short hours;
    private Double price;
    private Date dateSession;

    public Long getId() {
        return id;
    }

    public WalkingSessionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Short getHours() {
        return hours;
    }

    public WalkingSessionResource setHours(Short hours) {
        this.hours = hours;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public WalkingSessionResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getDateSession() {
        return dateSession;
    }

    public WalkingSessionResource setDateSession(Date dateSession) {
        this.dateSession = dateSession;
        return this;
    }
}
