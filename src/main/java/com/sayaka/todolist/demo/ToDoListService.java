package com.sayaka.todolist.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ToDoList findTask(Integer id) {
        Optional<ToDoList> task = this.toDoListMapper.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new UserNotExistException("task not found");
        }
    }

    public ToDoList insert(String title, String description, Boolean status){
        ToDoList task = ToDoList.creatTask(title, description, status);
        toDoListMapper.insert(task);
        return task;
    }

}
