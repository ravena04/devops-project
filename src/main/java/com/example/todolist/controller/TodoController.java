package com.example.todolist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.model.Todo;

@Controller
public class TodoController {
    private final List<Todo> todos = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todos);
        model.addAttribute("todo", new Todo());
        model.addAttribute("total", todos.size());
        model.addAttribute("completedCount", todos.stream().filter(Todo::isCompleted).count());
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
            todos.get(index).setCompleted(!todos.get(index).isCompleted());
        }
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
        }
        return "redirect:/";
    }

    @PostMapping("/clearCompleted")
    public String clearCompleted() {
        todos.removeIf(Todo::isCompleted);
        return "redirect:/";
    }

    @PostMapping("/clearAll")
    public String clearAll() {
        todos.clear();
        return "redirect:/";
    }
}
