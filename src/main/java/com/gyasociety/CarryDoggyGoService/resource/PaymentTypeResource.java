package com.gyasociety.carrydoggygoservice.resource;

import com.gyasociety.carrydoggygoservice.domain.model.AuditModel;

public class PaymentTypeResource extends AuditModel {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public PaymentTypeResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentTypeResource setName(String name) {
        this.name = name;
        return this;
    }
}
