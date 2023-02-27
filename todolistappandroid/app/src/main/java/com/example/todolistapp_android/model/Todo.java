package com.example.todolistapp_android.model;

import com.google.gson.annotations.SerializedName;

public class Todo {
    private int id;
    @SerializedName("taskName")
    private String name;
    @SerializedName("date")
    private boolean status;

    public Todo(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
