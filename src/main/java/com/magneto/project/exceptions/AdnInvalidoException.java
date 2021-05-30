package com.magneto.project.exceptions;

public class AdnInvalidoException extends Exception{

    private String message;

    public AdnInvalidoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
