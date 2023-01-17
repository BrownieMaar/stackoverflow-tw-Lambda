package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;

import java.util.List;

public interface AnswersDAO {
    int getAnswerCountByQuestionId(int questionId);
    List<Answer> getAnswersByQuestionId(int questionId);
}
