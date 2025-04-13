package com.github.allieschen.todo_api_java.repository;

import com.github.allieschen.todo_api_java.mapper.TodoMapper;
import com.github.allieschen.todo_api_java.model.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    private final TodoMapper todoMapper;

    public TodoRepository(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public List<TodoItem> findAll() {
        return todoMapper.findAll();
    }

    public Optional<TodoItem> findById(Long id) {
        return todoMapper.findById(id);
    }

    public Long save(TodoItem todo) {

        return todoMapper.insert(todo);
    }
}
