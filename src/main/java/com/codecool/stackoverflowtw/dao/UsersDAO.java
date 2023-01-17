package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.User;

public interface UsersDAO {
    User getUserFromUserId(int id);
}
