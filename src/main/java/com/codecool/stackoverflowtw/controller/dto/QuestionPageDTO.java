package com.codecool.stackoverflowtw.controller.dto;

import com.codecool.stackoverflowtw.types.User;

import java.time.LocalDateTime;
import java.util.List;

public record QuestionPageDTO(int id, String title, String description, LocalDateTime created, User user, List<AnswerDTO> answers) {
}
