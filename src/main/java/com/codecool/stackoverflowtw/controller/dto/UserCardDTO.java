package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record UserCardDTO(int id, String name, LocalDateTime registration, int questions, int answers) {
}
