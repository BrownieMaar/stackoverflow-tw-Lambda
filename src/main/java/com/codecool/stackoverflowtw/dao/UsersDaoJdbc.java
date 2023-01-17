package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Database;

public class UsersDaoJdbc implements UsersDAO {
    Database database;

    public UsersDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public String getUsernameFromUserId(int id) {
        // TODO
        return null;
    }
}
