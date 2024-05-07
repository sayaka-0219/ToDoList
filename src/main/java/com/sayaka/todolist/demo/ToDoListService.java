package com.sayaka.todolist.demo;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoListService {

    private final ToDoListMapper toDoListMapper;

    public ToDoListService(ToDoListMapper toDoListMapper) {
        this.toDoListMapper = toDoListMapper;
    }

    public List<ToDoList> findAllTodolist(){
        List<ToDoList> Lists = toDoListMapper.findAll();
        return Lists;
    }
}
