package com.example.todolistapp_android.viewholder;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapp_android.R;
import com.example.todolistapp_android.model.Todo;
import com.example.todolistapp_android.service.TodoService;

import java.util.function.Supplier;

public class TodoViewHolder extends RecyclerView.ViewHolder {

    private Fragment _fragment;
    private TextView nameTextView;
    private CheckBox statusCheckbox;
    private View view;
    private ImageButton deleteImage;
    private TodoService todoService;
    public TodoViewHolder(@NonNull View itemView, Fragment fragment) {
        this(itemView);
        _fragment = fragment;
        todoService = new TodoService();
    }

    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.todo_item_name_textview);
        statusCheckbox = itemView.findViewById(R.id.todo_item_done_checkbox);
        deleteImage =  itemView.findViewById(R.id.delete_item_img);
        view = itemView;
    }



    public void display(Todo todo, Runnable method) {
        nameTextView.setText(todo.getName());
        statusCheckbox.setChecked(todo.isStatus());
        statusCheckbox.setOnCheckedChangeListener((e, c)-> {
            todo.setStatus(c);
        });
        deleteImage.setOnClickListener((e) -> {
            todoService.deleteTodo(todo);
            method.run();
        });
    }

    public static TodoViewHolder create(ViewGroup parent, Fragment fragment) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view, fragment);
    }
}
