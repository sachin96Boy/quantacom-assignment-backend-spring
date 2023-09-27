package dev.sachin96boy.employbend.payload;

import lombok.Data;

@Data
public class LoginRequest {


    private String username;
    private String password;
}
