package com.github.allieschen.todo_api_java.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public class CreateTodoRequest {
    @NotNull
    private String title;
    private String description;
    @NotNull
    private boolean completed;

    public CreateTodoRequest() {};

    public CreateTodoRequest(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
