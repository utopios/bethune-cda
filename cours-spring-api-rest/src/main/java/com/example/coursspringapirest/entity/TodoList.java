package com.example.coursspringapirest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date endDate;
    private boolean complete;

    @OneToMany(mappedBy = "todoList")
    private List<TodoItem> todoItems;
}
