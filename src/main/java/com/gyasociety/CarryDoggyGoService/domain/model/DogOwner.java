package com.gyasociety.CarryDoggyGoService.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="dog_owners")
public class DogOwner extends User{

    @Size(max = 100)
    private String address;

    public String getAddress() {
        return address;
    }

    public DogOwner setAddress(String address) {
        this.address = address;
        return this;
    }
}
