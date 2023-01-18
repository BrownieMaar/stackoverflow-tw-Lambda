package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswersDaoJdbc implements AnswersDAO {
    Database database;

    public AnswersDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public int getAnswerCountByQuestionId(int questionId) {
        String template = "SELECT count(id) as result FROM answers WHERE question_id = ? GROUP BY question_id;";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("result");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<Answer> getAnswersByQuestionId(int questionId) {
        String template = "SELECT * FROM answers WHERE question_id = ?";
        List<Answer> answers = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                answers.add(new Answer(
                        resultSet.getInt("id"),
                        resultSet.getString("answer"),
                        resultSet.getTimestamp("created").toLocalDateTime(),
                        resultSet.getInt("question_id"),
                        resultSet.getInt("user_id")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return answers;
    }
}
