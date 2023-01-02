package com.crud.Rocket_Elevators_Java_API.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AuthResponse {

    private String email;
    private String accessToken;

}


