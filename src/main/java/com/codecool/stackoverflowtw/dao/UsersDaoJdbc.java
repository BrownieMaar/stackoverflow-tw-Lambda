package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Database;
import com.codecool.stackoverflowtw.dao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoJdbc implements UsersDAO {
    Database database;

    public UsersDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public User getUserFromUserId(int id) {
        String template = "SELECT id, name, registration FROM users WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(id, resultSet.getString("name"), resultSet.getTimestamp("registration").toLocalDateTime());
            } else {
                System.out.println("No user with that id.");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
