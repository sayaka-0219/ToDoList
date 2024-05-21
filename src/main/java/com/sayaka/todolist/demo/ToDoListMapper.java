package com.sayaka.todolist.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ToDoListMapper {
    @Select("SELECT * FROM todolist")
    List<ToDoList> findAll();

    @Insert("INSERT INTO todolist (title,description,status) VALUES (#{title},#{description},#{status})")
    @Options (useGeneratedKeys = true, keyProperty = "id")
    void insert(ToDoList task);


}
