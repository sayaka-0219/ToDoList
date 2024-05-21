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

    @GetMapping("/tasks/{id}")
    public ToDoList getTask(@PathVariable("id") Integer id) {
        return toDoListService.findTask(id);
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

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<ToDoListResponse> update( @PathVariable("id") int id, @RequestBody @Validated ToDoListRequest taskRequest) {
        ToDoList task = toDoListService.update(id, taskRequest.getTitle(),taskRequest.getDescription(),taskRequest.getStatus());
        ToDoListResponse body = new ToDoListResponse("task updated");
        return ResponseEntity.ok(body);
    }
}
