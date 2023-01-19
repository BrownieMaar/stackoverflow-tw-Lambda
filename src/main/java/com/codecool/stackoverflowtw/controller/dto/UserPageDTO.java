package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record UserPageDTO(int id, String name, LocalDateTime registration, boolean isAdmin, int questions, int answers) {
}
