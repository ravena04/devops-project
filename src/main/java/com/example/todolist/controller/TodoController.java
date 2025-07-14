// src/main/java/com/example/todolist/controller/TodoController.java
package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TodoController {
    private List<Todo> todos = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todos);
        model.addAttribute("todo", new Todo());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todos.add(todo);
        return "redirect:/";
    }

    @PostMapping("/complete")
    public String completeTodo(@RequestParam int index) {
        if (index >= 0 && index < todos.size()) {
            todos.get(index).setCompleted(true);
        }
        return "redirect:/";
    }
}
