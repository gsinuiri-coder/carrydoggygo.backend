package com.gyasociety.carrydoggygoservice.resource;


import java.util.Date;

public class SaveWalkingSessionResource {

    private Short hours;
    private Double price;
    private Date dateSession;
    private Long dogWalkerId;
    private Long paymentTypeId;

    public Short getHours() {
        return hours;
    }

    public SaveWalkingSessionResource setHours(Short hours) {
        this.hours = hours;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SaveWalkingSessionResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getDateSession() {
        return dateSession;
    }

    public SaveWalkingSessionResource setDateSession(Date dateSession) {
        this.dateSession = dateSession;
        return this;
    }

    public Long getDogWalkerId() {
        return dogWalkerId;
    }

    public SaveWalkingSessionResource setDogWalkerId(Long dogWalkerId) {
        this.dogWalkerId = dogWalkerId;
        return this;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public SaveWalkingSessionResource setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
        return this;
    }
}
