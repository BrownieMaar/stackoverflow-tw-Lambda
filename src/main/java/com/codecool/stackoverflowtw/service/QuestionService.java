package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.QuestionCardDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionPageDTO;
import com.codecool.stackoverflowtw.dao.AnswersDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionsDAO questionsDAO;
    private UsersDAO usersDAO;
    private AnswersDAO answersDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO, UsersDAO usersDAO, AnswersDAO answersDAO) {
        this.questionsDAO = questionsDAO;
        this.usersDAO = usersDAO;
        this.answersDAO = answersDAO;
    }

    public List<QuestionCardDTO> getAllQuestions() {
        return questionsDAO.getAllQuestions().stream().map(q -> new QuestionCardDTO(q.getId(), q.getTitle(), q.getCreated(), usersDAO.getUserFromUserId(q.getUser_id()), 0)).toList();
    }

    public QuestionPageDTO getQuestionById(int id) {
      Question question = questionsDAO.getQuestionById(id);
        return new QuestionPageDTO(question.getId(), question.getTitle(), question.getDescription(),
                question.getCreated(), new User(question.getUser_id(), "Dénes", LocalDateTime.now()), new ArrayList<>());
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
