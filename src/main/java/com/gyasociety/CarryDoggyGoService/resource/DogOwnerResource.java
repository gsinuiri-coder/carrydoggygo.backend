package com.gyasociety.CarryDoggyGoService.resource;

import com.gyasociety.CarryDoggyGoService.domain.model.User;

public class DogOwnerResource extends User {

    private Long id;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String address;

    public Long getId() {
        return id;
    }

    public DogOwnerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DogOwnerResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DogOwnerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogOwnerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DogOwnerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public DogOwnerResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
