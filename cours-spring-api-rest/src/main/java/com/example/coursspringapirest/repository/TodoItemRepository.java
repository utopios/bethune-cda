package com.example.coursspringapirest.repository;

import com.example.coursspringapirest.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {
    public List<TodoItem> findAllByTodoListId(int id);
}
