package com.example.correctiontodolist.controller;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todo")
@ResponseBody
public class TodoController {

    @Autowired
    private TodoService _todoService;

    @PostMapping("")
    public Todo post(@RequestParam String title, @RequestParam String description) throws Exception {
        try {
            Todo todo = _todoService.createTodo(title, description);
            return todo;
        }catch (Exception ex) {
            throw ex;
        }
    }

    @PostMapping("/update")
    public Todo post(@RequestParam Integer id, @RequestParam String title, @RequestParam String description) throws Exception {
        try {
            Todo todo = _todoService.updateTodo(id,title, description);
            return todo;
        }catch (Exception ex) {
            throw ex;
        }
    }
}
