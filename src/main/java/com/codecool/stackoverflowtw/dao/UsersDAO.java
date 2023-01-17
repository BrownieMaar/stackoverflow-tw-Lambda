package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.types.User;

public interface UsersDAO {
    User getUserFromUserId(int id);
}
