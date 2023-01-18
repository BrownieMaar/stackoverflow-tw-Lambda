package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionCardDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    void sayHi();

    List<Question> getAllQuestions();

    Question getQuestionById(int id);

    Integer addNewQuestion(NewQuestionDTO question);

}
