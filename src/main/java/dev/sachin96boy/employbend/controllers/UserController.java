package dev.sachin96boy.employbend.controllers;

import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.payload.PasswordResetRequest;
import dev.sachin96boy.employbend.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
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

    @PutMapping("/{id}")
    public  ResponseEntity<Optional<UserModel>> updateSingleUser(@PathVariable String id, @RequestBody PasswordResetRequest passwordResetRequest){
        return new ResponseEntity<Optional<UserModel>>(userService.updatePassword(id, passwordResetRequest), HttpStatus.OK);
    }
}
