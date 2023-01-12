package com.example.coursspringapirest.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDTO {
    private int id;
    private String firstName;
    private String lastName;

    //HATEOAS
    private String _selfLink;
    private String _editLink;
}