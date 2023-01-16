package com.example.democlient.service;


import com.example.democlient.Person;
import com.example.democlient.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonService {



    public List<Person> getFromApi() {
        RestClient<List<Person>, String> restClient = new RestClient<>();
        return restClient.get("api/person", (Class<List<Person>>) Collections.<Person>emptyList().getClass());
    }
}
