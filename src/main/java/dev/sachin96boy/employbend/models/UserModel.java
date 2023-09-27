package dev.sachin96boy.employbend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @Generated
    private String id;

    private String userEmail;
    private String userName;

    private String password;

    private UserType userType;

    public UserModel(String userName, String userEmail, String password){
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.userEmail=userEmail;
        this.password = password;
        this.userType= UserType.USER;
    }



}
