package com.sayaka.todolist.demo;

public class UserNotExistException extends RuntimeException {
        public UserNotExistException(String message) {
            super(message);
        }

}
