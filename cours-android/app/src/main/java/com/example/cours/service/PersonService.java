package com.example.cours.service;

import com.example.cours.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PersonService {

    @GET("/person")
    Call<List<Person>> getPersons();

    @GET("/person/{id}")
    Call<List<Person>> getPersonById(@Path("id") int id);

    @Headers("content-type: enctype/multipart-formdata")
    @POST("/person")
    void create(@Body Person person);
}
