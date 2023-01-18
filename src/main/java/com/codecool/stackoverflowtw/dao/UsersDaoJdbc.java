package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Database;
import com.codecool.stackoverflowtw.dao.model.NewUser;
import com.codecool.stackoverflowtw.dao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbc implements UsersDAO {
    Database database;

    public UsersDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public List<User> getAllUsers() {
        String template = "SELECT id, name, registration FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = database.getConnection(); PreparedStatement statement = connection.prepareStatement(template)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("registration").toLocalDateTime()));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserFromUserId(int id) {
        String template = "SELECT id, name, registration FROM users WHERE id = ?";

        try (Connection connection = database.getConnection(); PreparedStatement statement = connection.prepareStatement(template)) {
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

    @Override
    public int countQuestionsByUser(int userId) {
        String template = "SELECT COUNT(id) AS questionCount FROM questions WHERE user_id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                System.out.println("There was a problem with counting the questions of user: " + userId);
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countAnswersByUser(int userId) {
        String template = "SELECT COUNT(id) AS answerCount FROM answers WHERE user_id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                System.out.println("There was a problem with counting the answers of user: " + userId);
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int createUser(NewUser user) {
        String template = "INSERT INTO users (name, password, registration) " +
                "VALUES (?, ?, localtimestamp(2)) RETURNING id";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            ResultSet result = statement.executeQuery();
            if  (result.next()) {
                return result.getInt(1);
            } else {
                System.out.println("Could not create this user.");
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int id) {
        String template = "DELETE FROM users WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
