package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.NewQuestion;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    void sayHi();

    List<Question> getAllQuestions();

    Question getQuestionById(int id);

    Boolean deleteQuestionById(int id);

    Integer addNewQuestion(NewQuestion question);


}
