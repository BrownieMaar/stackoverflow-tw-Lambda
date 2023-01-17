package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Database;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {
    Database database;

    public QuestionsDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public List<Question> getAllQuestions() {
        String template = "SELECT * FROM questions";
        List<Question> questions = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                questions.add(new Question(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4).toLocalDateTime(), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    @Override
    public Question getQuestionById(int id) {
        String template = "SELECT * FROM questions WHERE id = ?";
        Question question = null;
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            ResultSet resultSet = statement.executeQuery(template);
            statement.setInt(1, id);
            while (resultSet.next()) {
                question = new Question(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("description"), resultSet.getTimestamp("created").toLocalDateTime(),
                        resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return question;
    }
}
