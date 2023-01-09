package com.example.coursspringapirest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String taskName;
    private boolean date;

    @ManyToOne
    private TodoList todoList;
}
