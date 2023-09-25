package dev.sachin96boy.employbend.payload;

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

    public JwtResponse(String token, String id, String userName, String userEmail){
        this.token = token;
        this.id = id;
        this.userEmail =userEmail;
    }
}
