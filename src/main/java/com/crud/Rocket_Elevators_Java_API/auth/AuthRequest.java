package com.crud.Rocket_Elevators_Java_API.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

}


