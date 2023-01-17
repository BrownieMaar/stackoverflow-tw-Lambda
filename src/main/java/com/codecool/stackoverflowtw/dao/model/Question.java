package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public class Question {
    int id;
    String title;
    String description;
    LocalDateTime created;
    int user_id;

    public Question(int id, String title, String description, LocalDateTime created, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getUser_id() {
        return user_id;
    }
}
