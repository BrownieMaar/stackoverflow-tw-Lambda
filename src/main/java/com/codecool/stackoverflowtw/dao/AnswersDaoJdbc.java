package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.Database;
import com.codecool.stackoverflowtw.dao.model.NewAnswer;

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

    private Answer getAnswerById(int id) {
        String template = "SELECT * FROM answers WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Answer(
                        resultSet.getInt("id"),
                        resultSet.getString("answer"),
                        resultSet.getTimestamp("created").toLocalDateTime(),
                        resultSet.getInt("question_id"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Answer not found. Error message:");
            System.out.println(e.getErrorCode());
        }
        return null;
    }

    @Override
    public Answer createAnswer(NewAnswer newAnswer) {
        String template = "INSERT INTO answers (answer, created, question_id, user_id) VALUES (?, localtimestamp, ?, ?) RETURNING id";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setString(1, newAnswer.getAnswer());
            statement.setInt(2, newAnswer.getQuestion_id());
            statement.setInt(3, newAnswer.getUser_id());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getAnswerById(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to insert answer. Error message:");
            System.out.println(e.getSQLState());
        }
        return null;
    }

    @Override
    public boolean deleteAnswer(int id) {
        String template = "DELETE FROM answers WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(template)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            return false;
        }
    }
}
