package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.*;
import com.codecool.stackoverflowtw.dao.UsersDAO;
import com.codecool.stackoverflowtw.dao.model.NewUser;
import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UsersDAO usersDAO;

    @Autowired
    public UserService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public List<UserCardDTO> getAllUsers() {
        return usersDAO.getAllUsers().stream().map(u -> new UserCardDTO(u.getId(), u.getName(), u.getRegistrationDate(), usersDAO.countQuestionsByUser(u.getId()), usersDAO.countAnswersByUser(u.getId()))).toList();
    }

    public UserPageDTO getUserById(int id) {
        User user = usersDAO.getUserFromUserId(id);
        int questionCount = usersDAO.countQuestionsByUser(id);
        int answerCount = usersDAO.countAnswersByUser(id);

        return new UserPageDTO(id, user.getName(), user.getRegistrationDate(), questionCount, answerCount);
    }

    public boolean deleteUserById(int id) {
        return usersDAO.deleteUser(id);
    }

    public int addNewUser (NewUserDTO user) {
        return usersDAO.createUser(new NewUser(user.name(), user.password()));
    }
}
