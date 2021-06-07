package com.gyasociety.CarryDoggyGoService.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveDogOwnerResource {
    @NotNull
    @Size(max = 80)
    private String userName;

    @NotNull
    @Size(max = 80)
    private String password;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String lastName;

    @Size(max = 100)
    private String address;

    public String getUserName() {
        return userName;
    }

    public SaveDogOwnerResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveDogOwnerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveDogOwnerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveDogOwnerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveDogOwnerResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
