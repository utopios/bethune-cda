package com.example.democlient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String phone;
    private String email;
}