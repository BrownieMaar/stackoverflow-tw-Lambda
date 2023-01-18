package com.codecool.stackoverflowtw.dao.model;

public class NewUser {

    String name;
    String password;

    public NewUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
