package com.bosonit.EJ3.Person.Exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
