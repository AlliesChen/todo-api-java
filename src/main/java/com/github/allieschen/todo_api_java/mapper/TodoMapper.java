package com.github.allieschen.todo_api_java.mapper;

import com.github.allieschen.todo_api_java.model.TodoItem;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TodoMapper {
    @Insert("INSERT INTO todos (title, description, completed, created_at, updated_at) VALUES (#{title}, #{description}, #{completed}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(TodoItem todo);

    @Select("SELECT * FROM todos ORDER BY id")
    List<TodoItem> findAll();

    @Select("SELECT id, title, description, completed, created_at, updated_at FROM todos WHERE id = #{id}")
//    @Results(id = "GetTodo", value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "title", column = "title"),
//            @Result(property = "description", column = "description"),
//            @Result(property = "completed", column = "completed"),
//            @Result(property = "createdAt", column = "created_at"),
//            @Result(property = "updatedAt", column = "updated_at")
//    })
    Optional<TodoItem> findById(@Param("id") Long id);
}
