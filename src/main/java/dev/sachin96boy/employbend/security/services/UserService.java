package dev.sachin96boy.employbend.security.services;

import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserModel> allUsers(){
        return userRepository.findAll();
    }

//    using optional becaus it can also
//    return null if no data found
    public Optional<UserModel> singleUser(String id){
        return  userRepository.findById(id);
    }
}
