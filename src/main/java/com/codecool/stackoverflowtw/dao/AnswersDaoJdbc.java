package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Database;

public class AnswersDaoJdbc implements AnswersDAO {
    Database database;

    public AnswersDaoJdbc(Database database) {
        this.database = database;
    }

    @Override
    public int getAnswerCountByQuestionId(int questionId) {
        return 0;
    }
}
