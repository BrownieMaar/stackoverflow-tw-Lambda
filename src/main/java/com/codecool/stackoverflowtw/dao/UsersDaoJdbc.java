package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Database;
import com.codecool.stackoverflowtw.types.User;

import java.time.LocalDateTime;

public class UsersDaoJdbc implements UsersDAO {
    Database database;

    public UsersDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public User getUserFromUserId(int id) {
        // TODO
        return new User(1, "MiZo", LocalDateTime.now());
    }
}
