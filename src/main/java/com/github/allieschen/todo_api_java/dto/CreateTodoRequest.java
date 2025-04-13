package com.github.allieschen.todo_api_java.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public class CreateTodoRequest {
    @NotNull
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
