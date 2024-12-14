package com.example.qsproject.qsproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @version 1.0
 * @author Sem Erros
 */

/**
 * This class handles "Not Found" errors.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exceptions extends RuntimeException{

    /**
     * Constructs a new Exceptions with the specified detail message.
     *
     * @param message the detail message that describes the error
     */

    public Exceptions(String message){
        super(message);
    }
}
