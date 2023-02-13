package com.bethune.demofromationapirest.exception;

public class CustomNotFoundException extends Exception{

    private final static String message = "Resource not found";

    public CustomNotFoundException() {
        super(message);
    }
}
