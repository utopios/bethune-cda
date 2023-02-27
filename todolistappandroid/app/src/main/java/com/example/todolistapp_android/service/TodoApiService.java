package com.example.todolistapp_android.service;

import com.example.todolistapp_android.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TodoApiService {

    @GET("todolists/{id}/todoitems")
    public Call<List<Todo>> getTasks(@Path("id") int id);

    @POST("todolists/{id}/todoitems")
    public Call<Todo> postTask(@Path("id") int id, @Body Todo todo);
}
