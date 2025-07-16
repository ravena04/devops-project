package com.example.todolist.model;

public class Todo {
    private String task;
    private boolean completed;
    private String dueDate;

    public Todo() {}

    public Todo(String task, String dueDate) {
        this.task = task;
        this.dueDate = dueDate;
        this.completed = false;
    }

    // Getters and Setters
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
}
