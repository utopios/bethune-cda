package com.example.democlient.service;


import com.example.democlient.Person;
import com.example.democlient.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonService {



    public Person[] getFromApi() {
        RestClient<Person[], String> restClient = new RestClient<>();
        //return restClient.get("api/person", (Class<List<Person>>) Collections.<Person>emptyList().getClass());
        return restClient.get("api/person", Person[].class);
    }

    public Person PostToApi(String name) {
        RestClient<Person, Person> restClient = new RestClient<>();
        Person p = new Person();
        p.setName(name);
        return restClient.Post("api/person",p, Person.class);
    }
}
