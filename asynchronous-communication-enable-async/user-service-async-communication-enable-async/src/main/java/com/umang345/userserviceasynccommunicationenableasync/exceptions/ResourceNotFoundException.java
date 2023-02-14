package com.umang345.userserviceasynccommunicationenableasync.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception
{
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){
        super("The requested resource could not be found");
    }
}
