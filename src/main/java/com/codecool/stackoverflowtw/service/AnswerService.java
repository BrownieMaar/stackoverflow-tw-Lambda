package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.AnswersDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.NewAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private AnswersDAO answersDAO;

    @Autowired
    public AnswerService(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }

    public boolean deleteAnswerById(int id) {
        // TODO
        return false;
    }

    public boolean addNewAnswer(NewAnswerDTO newAnswerDTO) {
        return answersDAO.createAnswer(new NewAnswer(newAnswerDTO.answer(), newAnswerDTO.question_id(), newAnswerDTO.user_id()));
    }

}
