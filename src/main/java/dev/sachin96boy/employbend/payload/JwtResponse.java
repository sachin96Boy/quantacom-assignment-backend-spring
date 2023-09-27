package dev.sachin96boy.employbend.payload;

import dev.sachin96boy.employbend.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String userName;
    private String userEmail;
    private UserType userType;

    public JwtResponse(String token, String id, String userName, String userEmail, UserType userType){
        this.token = token;
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userType = userType;
    }
}
