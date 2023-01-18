package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.NewAnswer;
import com.codecool.stackoverflowtw.service.AnswerService;

import java.util.List;

public interface AnswersDAO {
    int getAnswerCountByQuestionId(int questionId);
    List<Answer> getAnswersByQuestionId(int questionId);

    boolean createAnswer(NewAnswer newAnswer);
    boolean deleteAnswer(int id);
}
