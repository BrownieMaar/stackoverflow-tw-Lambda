package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public class User {
    int id;
    String name;

    LocalDateTime registrationDate;
    boolean isAdmin;

    public User(int id, String name, LocalDateTime registrationDate, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.isAdmin = isAdmin;
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

    public boolean isAdmin() {
        return isAdmin;
    }
}
