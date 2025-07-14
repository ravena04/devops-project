// src/main/java/com/example/todolist/model/Todo.java
package com.example.todolist.model;

public class Todo {
    private String task;
    private boolean completed;

    public Todo() {}

    public Todo(String task) {
        this.task = task;
        this.completed = false;
    }

    // Getters and setters
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
