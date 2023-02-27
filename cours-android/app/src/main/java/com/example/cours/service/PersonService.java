package com.example.cours.service;

import com.example.cours.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonService {

    @GET("person")
    Call<List<Person>> getPersons();
}
