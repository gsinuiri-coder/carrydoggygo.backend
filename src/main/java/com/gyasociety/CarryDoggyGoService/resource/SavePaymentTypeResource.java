package com.gyasociety.carrydoggygoservice.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SavePaymentTypeResource {

    @NotNull
    @Size(max = 100)
    private String name;

    public String getName() {
        return name;
    }

    public SavePaymentTypeResource setName(String name) {
        this.name = name;
        return this;
    }
}
