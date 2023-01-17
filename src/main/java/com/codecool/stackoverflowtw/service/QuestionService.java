package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.QuestionCardDTO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    private QuestionsDAO questionsDAO;
    private UsersDAO usersDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO, UsersDAO usersDAO) {
        this.questionsDAO = questionsDAO;
        this.usersDAO = usersDAO;
    }

    public List<QuestionCardDTO> getAllQuestions() {
        return questionsDAO.getAllQuestions().stream().map(q -> new QuestionCardDTO(q.getId(), q.getTitle(), q.getCreated(), usersDAO.getUserFromUserId(q.getUser_id()), 0)).toList();
    }

    public QuestionCardDTO getQuestionById(int id) {
        // TODO
        questionsDAO.sayHi();
        return null;
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return false;
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODO
        int createdId = 0;
        return createdId;
    }
}
