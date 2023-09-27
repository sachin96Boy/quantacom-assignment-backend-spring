package dev.sachin96boy.employbend.payload;

import dev.sachin96boy.employbend.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignupResponse {
    private String id;
    private String userName;
    private String userEmail;
    private String password;
    private UserType userType;
}
