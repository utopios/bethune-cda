package com.example.todolistapp_android.util;

import com.example.todolistapp_android.service.TodoApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Retrofit retrofit;

    private TodoApiService apiService;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(TodoApiService.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if(instance == null)
            instance = new RetrofitClient();
        return instance;
    }

    public TodoApiService getApiService() {
        return apiService;
    }
}
