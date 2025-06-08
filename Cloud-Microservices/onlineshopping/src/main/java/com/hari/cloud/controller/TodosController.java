package com.hari.cloud.controller;

import com.hari.cloud.dto.TodosResponse;
import com.hari.cloud.service.TodosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodosController {

    private static final Logger log = LoggerFactory.getLogger(TodosController.class);

    @Autowired
    private TodosService todosService;

    @GetMapping("/details")
    public ResponseEntity<TodosResponse> getTodosDetails() {
        log.info("Fetching todos details");
        return ResponseEntity.ok(todosService.getTodosDetails()); // Placeholder for actual implementation
    }

}
