package com.codecool.stackoverflowtw.controller.dto;

import com.codecool.stackoverflowtw.types.User;

import java.time.LocalDateTime;

public record QuestionCardDTO(int id, String title, LocalDateTime created, User user, int answerCount) {}
