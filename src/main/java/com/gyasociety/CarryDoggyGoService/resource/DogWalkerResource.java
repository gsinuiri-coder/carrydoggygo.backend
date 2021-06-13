package com.gyasociety.carrydoggygoservice.resource;

import com.gyasociety.carrydoggygoservice.domain.model.AuditModel;

public class DogWalkerResource extends AuditModel {

    private Long id;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String description;

    public Long getId() {
        return id;
    }

    public DogWalkerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DogWalkerResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DogWalkerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogWalkerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DogWalkerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DogWalkerResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
