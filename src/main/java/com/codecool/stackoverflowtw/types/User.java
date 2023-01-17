package com.codecool.stackoverflowtw.types;

import java.time.LocalDateTime;

public class User {
    int id;
    String name;

    LocalDateTime registrationDate;

    public User(int id, String name, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
