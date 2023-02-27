package com.example.todolistapp_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.todolistapp_android.databinding.FragmentFormBinding;
import com.example.todolistapp_android.model.Todo;
import com.example.todolistapp_android.service.TodoService;
import com.example.todolistapp_android.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormFragment extends Fragment {

    FragmentFormBinding binding;
    TodoService todoService;
    public FormFragment() {
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
        binding = FragmentFormBinding.inflate(inflater,container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.validButtton.setOnClickListener((e) -> {
            if(binding.nameEdittext.getText().length() > 3) {
                //todoService.addTodo(binding.nameEdittext.getText().toString());
                RetrofitClient.getInstance().getApiService().postTask(1, new Todo(0, binding.nameEdittext.getText().toString(), false)).enqueue(new Callback<Todo>() {
                    @Override
                    public void onResponse(Call<Todo> call, Response<Todo> response) {
                        Todo todoResponse = response.body();
                        if(!todoResponse.equals(null) && todoResponse.getId() > 0) {
                            NavDirections action = FormFragmentDirections.actionFormToList();
                            NavHostFragment.findNavController(FormFragment.this).navigate(action);
                        }
                        else {
                            Toast.makeText(getContext(),response.code() + " "+ response.message(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Todo> call, Throwable t) {
                        Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
            else {
                Toast.makeText(getContext(), "Merci de saisir un titre avec 4 caractères min", Toast.LENGTH_LONG).show();
            }
        });
    }
}