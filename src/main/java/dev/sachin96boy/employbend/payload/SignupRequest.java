package dev.sachin96boy.employbend.payload;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String userEmail;

    private String password;

}
