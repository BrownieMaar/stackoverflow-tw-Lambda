package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.*;
import com.codecool.stackoverflowtw.dao.AnswersDAO;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.NewUser;
import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersDAO usersDAO;
    private final AnswersDAO answersDAO;

    @Autowired
    public UserService(UsersDAO usersDAO, AnswersDAO answersDAO) {
        this.usersDAO = usersDAO;
        this.answersDAO = answersDAO;
    }

    public List<UserCardDTO> getAllUsers() {
        return usersDAO.getAllUsers().stream().map(u -> new UserCardDTO(u.getId(), u.getName(), u.getRegistrationDate(), usersDAO.countQuestionsByUser(u.getId()), usersDAO.countAnswersByUser(u.getId()))).toList();
    }

    public UserPageDTO getUserById(int id) {
        User user = usersDAO.getUserFromUserId(id);
        int questionCount = usersDAO.countQuestionsByUser(id);
        int answerCount = usersDAO.countAnswersByUser(id);

        return new UserPageDTO(id, user.getName(), user.getRegistrationDate(), user.isAdmin(), questionCount, answerCount);
    }

    public UserPageDTO getUserByNameAndPassword(NewUserDTO newUserDTO) {
        User user = usersDAO.getUserByNameAndPassword(new NewUser(newUserDTO.name(), newUserDTO.password()));
        if (user == null) {
            return null;
        }
        int questionCount = usersDAO.countQuestionsByUser(user.getId());
        int answerCount = usersDAO.countAnswersByUser(user.getId());
        return new UserPageDTO(user.getId(), user.getName(), user.getRegistrationDate(), user.isAdmin(), questionCount, answerCount);
    }

    public boolean deleteUserById(int id) {
        if (answersDAO.deleteAnswersByUserId(id)) {
            return usersDAO.deleteUser(id);
        }
        System.out.println("Couldn't delete answers of user no. " + id);
        return false;
    }

    public int addNewUser(NewUserDTO user) {
        return usersDAO.createUser(new NewUser(user.name(), user.password()));
    }

    public List<QuestionCardDTO> getQuestionsByUser(int id) {
        return usersDAO.getQuestionsByUser(id).stream().map(q -> new QuestionCardDTO(q.getId(), q.getTitle(),
                q.getCreated(), usersDAO.getUserFromUserId(q.getUser_id()),
                answersDAO.getAnswerCountByQuestionId(q.getId()), q.getUpVoteCount(), q.getDownVoteCount())).toList();
    }

    public List<AnswerDTO> getAnswersByUser(int id) {
        return usersDAO.getAnswersByUser(id).stream().map(a -> new AnswerDTO(a.getId(), a.getAnswer(),
                usersDAO.getUserFromUserId(id), a.getCreated(), a.getQuestion_id(), a.getUpVoteCount(), a.getDownVoteCount())).toList();
    }
}
