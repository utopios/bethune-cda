package com.example.correctiontodolist.service;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.repository.impl.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRespository _todoRespository;

    public Todo createTodo(String title, String description) throws Exception {
        if(title == null || description == null) {
            throw new Exception("Remplir la totalité des champs");
        }
        Todo todo = new Todo(title, description);
        if(_todoRespository.create(todo)) {
            return todo;
        }
        return null;
    }
}
