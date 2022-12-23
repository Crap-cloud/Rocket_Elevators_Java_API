package com.crud.Rocket_Elevators_Java_API.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InterventionsNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    public InterventionsNotFoundException( String message) {
        this.message = message;
    }
}

