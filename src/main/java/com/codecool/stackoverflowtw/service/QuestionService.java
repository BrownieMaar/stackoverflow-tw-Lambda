package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionCardDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionPageDTO;
import com.codecool.stackoverflowtw.dao.AnswersDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = usersDAO.getUserFromUserId(question.getUser_id());
        List<AnswerDTO> answerDTOList = createAnswerDTOList(answersDAO.getAnswersByQuestionId(id));

        return new QuestionPageDTO(question.getId(), question.getTitle(), question.getDescription(),
                question.getCreated(), user, answerDTOList);
    }

    public boolean deleteQuestionById(int id) {
        return questionsDAO.deleteQuestionById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODO
        int createdId = 0;
        return createdId;
    }

    private List<AnswerDTO> createAnswerDTOList(List<Answer> answerList) {
        List<AnswerDTO> answerDTOList = new ArrayList<>();
        for (Answer answer : answerList) {
            answerDTOList.add(new AnswerDTO(answer.getId(), answer.getAnswer(),
                    usersDAO.getUserFromUserId(answer.getUser_id()), answer.getCreated()));
        }
        return answerDTOList;
    }
}
