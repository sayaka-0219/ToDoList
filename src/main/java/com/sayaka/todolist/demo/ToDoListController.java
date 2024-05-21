package com.sayaka.todolist.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping("/todolist")
    public List<ToDoList> getLists(){
        return toDoListService.findAllTodolist();
    }

    @PostMapping("/tasks")
    public ResponseEntity<ToDoListResponse> insert(@RequestBody @Validated ToDoListRequest toDoListRequest, UriComponentsBuilder uriBuilder) {
        ToDoList task = toDoListService.insert(toDoListRequest.getTitle(), toDoListRequest.getDescription(), toDoListRequest.getStatus());
        URI location = uriBuilder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri();
        ToDoListResponse body = new ToDoListResponse("task created");
        return ResponseEntity.created(location).body(body);
    }
}
