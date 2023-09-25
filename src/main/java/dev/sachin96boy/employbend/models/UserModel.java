package dev.sachin96boy.employbend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

enum UserType{
    USER,
    ADMIN
}

@Document(collation = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    private String id;

    private String userEmail;
    private String userName;

    private UserType userType;


}
