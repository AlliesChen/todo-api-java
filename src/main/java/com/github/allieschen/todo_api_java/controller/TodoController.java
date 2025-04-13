package com.github.allieschen.todo_api_java.controller;

import com.github.allieschen.todo_api_java.dto.ApiResponse;
import com.github.allieschen.todo_api_java.dto.CreateTodoRequest;
import com.github.allieschen.todo_api_java.model.TodoItem;
import com.github.allieschen.todo_api_java.repository.TodoRepository;
import com.github.allieschen.todo_api_java.service.TodoService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController()
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> ping() {
        return ApiResponse.success("success", "pong");
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Long>> createTodo(@RequestBody @Valid CreateTodoRequest request) {
        System.out.println(request);
        Long todoId = todoService.createTodo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Todo created", todoId));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<TodoItem> getTodo(@PathVariable Long id) {
        TodoItem todo = todoService.getByIdOrThrow(id);
        return ApiResponse.success("Todo retrieved", todo);
    }
}
