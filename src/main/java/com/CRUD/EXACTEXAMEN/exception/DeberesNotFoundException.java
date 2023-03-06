package com.CRUD.EXACTEXAMEN.exception;

public class DeberesNotFoundException extends RuntimeException{
    public DeberesNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}
