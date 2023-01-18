package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {

    List<Question> getAllQuestions();

    Question getQuestionById(int id);

}
