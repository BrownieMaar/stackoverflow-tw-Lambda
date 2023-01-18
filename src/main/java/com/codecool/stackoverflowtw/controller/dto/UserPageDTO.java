package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record UserPageDTO(int id, String name, LocalDateTime registration, int questions, int answers) {
}
