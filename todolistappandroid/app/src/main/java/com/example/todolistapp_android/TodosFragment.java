package com.example.todolistapp_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolistapp_android.adapter.TodosAdapter;
import com.example.todolistapp_android.databinding.FragmentTodosBinding;
import com.example.todolistapp_android.model.Todo;
import com.example.todolistapp_android.service.TodoService;
import com.example.todolistapp_android.util.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosFragment extends Fragment {

    private TodosAdapter todosAdapter;
    private TodoService todoService;
    private FragmentTodosBinding binding;
    public TodosFragment() {
        todoService = new TodoService();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        todosAdapter = new TodosAdapter(new TodosAdapter.TodoDiff(), TodosFragment.this);
        binding.todosRecyclerview.setAdapter(todosAdapter);
        binding.todosRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.todosRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        RetrofitClient.getInstance().getApiService().getTasks(1).enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                List<Todo> todos = response.body();
                todosAdapter.submitList(todos);
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
        //todosAdapter.submitList(todoService.getTodos());
    }
}