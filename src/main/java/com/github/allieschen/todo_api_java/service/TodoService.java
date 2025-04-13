package com.github.allieschen.todo_api_java.service;

import com.github.allieschen.todo_api_java.dto.CreateTodoRequest;
import com.github.allieschen.todo_api_java.exception.NotFoundException;
import com.github.allieschen.todo_api_java.model.TodoItem;
import com.github.allieschen.todo_api_java.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Long createTodo(CreateTodoRequest todo) {
        LocalDateTime now = LocalDateTime.now();
        TodoItem newTodo = new TodoItem(
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
        System.out.println(newTodo);
        return todoRepository.save(newTodo);
    }

    public TodoItem getByIdOrThrow(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Todo not found with id " + id));
    }

    public List<TodoItem> findAllTodos() {
        return todoRepository.findAll();
    }
}
