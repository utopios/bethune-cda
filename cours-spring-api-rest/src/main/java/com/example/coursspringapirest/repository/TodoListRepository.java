package com.example.coursspringapirest.repository;

import com.example.coursspringapirest.entity.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {


}
