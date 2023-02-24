package com.example.todolistapp_android.service;

import com.example.todolistapp_android.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;

    public void addTodo(String name) {
        Todo todo = new Todo(++count, name, false);
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return  todos;
    }

    public void deleteTodo(Todo todo) {
        todos.remove(todo);
    }


}
