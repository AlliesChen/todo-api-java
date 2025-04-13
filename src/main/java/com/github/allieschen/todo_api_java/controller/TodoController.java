package com.github.allieschen.todo_api_java.controller;

import com.github.allieschen.todo_api_java.dto.ApiResponse;
import com.github.allieschen.todo_api_java.dto.CreateTodoRequest;
import com.github.allieschen.todo_api_java.model.TodoItem;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController()
public class TodoController {
    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> ping() {
        return ApiResponse.success("success", "pong");
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Long>> createTodo(@RequestBody @Valid CreateTodoRequest request) {

        Long todoId = (long) 1;
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Todo created", todoId));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<TodoItem> getTodo(@PathVariable Long id) {
        LocalDateTime now = LocalDateTime.now();
        return ApiResponse.success("Todo ID: " + id, new TodoItem("hello", "hello world!", now, now));
    }
}
