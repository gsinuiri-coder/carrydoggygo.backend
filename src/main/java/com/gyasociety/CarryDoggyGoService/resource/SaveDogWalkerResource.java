package com.gyasociety.CarryDoggyGoService.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveDogWalkerResource {

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

    @Size(max = 300)
    private String description;

    //    ---------------------------------
    public String getUserName() {
        return userName;
    }

    public SaveDogWalkerResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveDogWalkerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveDogWalkerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveDogWalkerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveDogWalkerResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
