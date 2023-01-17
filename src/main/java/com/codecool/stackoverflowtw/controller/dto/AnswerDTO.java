package com.codecool.stackoverflowtw.controller.dto;

import com.codecool.stackoverflowtw.dao.model.User;

import java.time.LocalDateTime;

public record AnswerDTO(int id, String answer, User user, LocalDateTime created) {
}
