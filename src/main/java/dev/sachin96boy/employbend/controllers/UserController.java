package dev.sachin96boy.employbend.controllers;

import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
//    get request
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return new ResponseEntity<List<UserModel>>(userService.allUsers(), HttpStatus.OK);
    }

//    get innformation by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> getSingleUser(@PathVariable String id){
        return new ResponseEntity<Optional<UserModel>>(userService.singleUser(id), HttpStatus.OK);
    }
}
