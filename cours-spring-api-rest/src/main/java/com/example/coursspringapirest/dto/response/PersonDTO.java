package com.example.coursspringapirest.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class PersonDTO extends RepresentationModel<PersonDTO> {
    private int id;
    private String firstName;
    private String lastName;

    //HATEOAS
    /*private String _selfLink;
    private String _editLink;*/
}