package com.sayaka.todolist.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ToDoListRequest {
    @NotBlank(message = "空白を許可しません")
    @Size(max = 255, message = "255文字以内で入力してください")
    private String title;
    private String description;
    @NotNull(message = "trueかfalseどちらかを必ず入力してください")
    private Boolean status;

    public ToDoListRequest(String title, String description, Boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getStatus() {
        return status;
    }
}
