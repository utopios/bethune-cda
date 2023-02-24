package com.example.todolistapp_android.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.todolistapp_android.model.Todo;
import com.example.todolistapp_android.viewholder.TodoViewHolder;

public class TodosAdapter extends ListAdapter<Todo, TodoViewHolder> {

    private Fragment _fragment;
    public TodosAdapter(@NonNull DiffUtil.ItemCallback<Todo> diffCallback, Fragment fragment) {
        this(diffCallback);
        _fragment = fragment;
    }

    protected TodosAdapter(@NonNull DiffUtil.ItemCallback<Todo> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TodoViewHolder.create(parent, _fragment);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = getItem(position);
        holder.display(todo);
    }

    public static class TodoDiff extends DiffUtil.ItemCallback<Todo> {

        @Override
        public boolean areItemsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem) {
            return oldItem.getName().equals(newItem.getName()) && oldItem.isStatus() == newItem.isStatus();
        }
    }
}
