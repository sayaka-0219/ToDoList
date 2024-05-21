package com.sayaka.todolist.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ToDoListMapper {
    @Select("SELECT * FROM todolist")
    List<ToDoList> findAll();

    @Select("SELECT * FROM todolist WHERE id = #{id}")
    Optional<ToDoList> findById(Integer id);

    @Insert("INSERT INTO todolist (title,description,status) VALUES (#{title},#{description},#{status})")
    @Options (useGeneratedKeys = true, keyProperty = "id")
    void insert(ToDoList task);

}
