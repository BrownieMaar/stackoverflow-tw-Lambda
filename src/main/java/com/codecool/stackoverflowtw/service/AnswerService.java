package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswersDAO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.NewAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswersDAO answersDAO;
    private final UsersDAO usersDAO;

    @Autowired
    public AnswerService(AnswersDAO answersDAO, UsersDAO usersDAO) {
        this.answersDAO = answersDAO;
        this.usersDAO = usersDAO;
    }

    public boolean deleteAnswerById(int id) {
        return answersDAO.deleteAnswer(id);
    }

    public AnswerDTO addNewAnswer(NewAnswerDTO newAnswerDTO) {
        Answer answer = answersDAO.createAnswer(new NewAnswer(newAnswerDTO.answer(), newAnswerDTO.question_id(), newAnswerDTO.user_id()));
        return new AnswerDTO(answer.getId(), answer.getAnswer(), usersDAO.getUserFromUserId(answer.getUser_id()), answer.getCreated());
    }

}
