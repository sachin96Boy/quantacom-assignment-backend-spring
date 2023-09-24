package dev.sachin96boy.employbend.controllers;

import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
//    get request
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return new ResponseEntity<List<UserModel>>(userService.allUsers(), HttpStatus.OK);
    }
}
