package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public class Question {
    int id;
    String title;
    String description;
    LocalDateTime created;
    int user_id;
    int upVoteCount;
    int downVoteCount;

    public Question(int id, String title, String description, LocalDateTime created, int user_id,
                    int upVoteCount, int downVoteCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.user_id = user_id;
        this.upVoteCount = upVoteCount;
        this.downVoteCount = downVoteCount;
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

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }
}
