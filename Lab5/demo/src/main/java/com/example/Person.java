package com.example;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private boolean isEmployed;
    private Address address;

    // Constructors
    public Person() {
    }

    public Person(String name, boolean isEmployed, Address address) {
        this.name = name;
        this.isEmployed = isEmployed;
        this.address = address;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " (" + (isEmployed ? "Employed" : "Unemployed") + ") — " + address;
    }
}
