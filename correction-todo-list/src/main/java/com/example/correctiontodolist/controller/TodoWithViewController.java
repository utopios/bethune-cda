package com.example.correctiontodolist.controller;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.service.TodoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//Ce contrôleur est à utiliser uniquement avec les vues en html en tyemleaf
@Controller
@RequestMapping("todos-html")
public class TodoWithViewController {
    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"","{status}"})
    public ModelAndView getTodos(@PathVariable(required = false) Boolean status) {
        ModelAndView mv = new ModelAndView("todos");
        List<Todo> todos = new ArrayList<>();
        if(status == null) {
            todos.addAll(todoService.getByStatus(false));
            todos.addAll(todoService.getByStatus(true));
        }
        else {
            todos.addAll(todoService.getByStatus(status));
        }
        mv.addObject("todos", todos);
        return mv;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getDetail(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("detail");
        mv.addObject("todo", todoService.getTodoById(id));
        return mv;
    }

    @GetMapping("/update/{id}")
    public void updapteStatus(@PathVariable Integer id, HttpServletResponse response) throws Exception {
        try {
            todoService.updateStatus(id);
            response.sendRedirect("/todos-html/detail/"+id);
        }catch (Exception ex) {
            throw ex;
        }
    }
}
