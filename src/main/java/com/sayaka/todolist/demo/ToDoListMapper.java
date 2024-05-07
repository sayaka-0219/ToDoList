package com.sayaka.todolist.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ToDoListMapper {
    @Select("SELECT * FROM todolist")
    List<ToDoList> findAll();

}
