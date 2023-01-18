package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/")
    public boolean addNewAnswer(@RequestBody NewAnswerDTO newAnswerDTO) {
        return answerService.addNewAnswer(newAnswerDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAnswer(@PathVariable int id) {
        return answerService.deleteAnswerById(id);
    }

}
