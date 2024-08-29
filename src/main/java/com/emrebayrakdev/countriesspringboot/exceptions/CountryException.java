package com.emrebayrakdev.countriesspringboot.exceptions;

public class CountryException extends AlreadyExistException{
    public CountryException(String message) {
        super(message);
    }
}
