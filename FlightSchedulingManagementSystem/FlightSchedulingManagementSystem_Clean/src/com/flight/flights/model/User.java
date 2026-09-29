package com.flight.flights.model;

public abstract class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void showRole();
}
