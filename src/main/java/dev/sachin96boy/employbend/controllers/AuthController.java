package dev.sachin96boy.employbend.controllers;


import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.payload.JwtResponse;
import dev.sachin96boy.employbend.payload.LoginRequest;
import dev.sachin96boy.employbend.payload.MessageResponse;
import dev.sachin96boy.employbend.payload.SignupRequest;
import dev.sachin96boy.employbend.repository.UserRepository;
import dev.sachin96boy.employbend.security.jwt.JWTUtils;
import dev.sachin96boy.employbend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {


            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );


            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.generateToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


            return ResponseEntity.ok(
                    new JwtResponse(
                            jwt,
                            userDetails.getId(),
                            userDetails.getUsername(),
                            userDetails.getUserEmail(),
                            userDetails.getUserType()
                    )
            );




    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest){
        if (userRepository.existsByuserName(signupRequest.getUsername())){
            return ResponseEntity.badRequest()
                    .body(
                            new MessageResponse("Error: Username already in list")
                    );
        }
        if (userRepository.existsByuserEmail(signupRequest.getUserEmail())){
            return ResponseEntity.badRequest()
                    .body(
                            new MessageResponse("Error: email already in list")
                    );
        }

//        create user
        UserModel user = new UserModel(
                signupRequest.getUsername(),
                signupRequest.getUserEmail(),
                passwordEncoder.encode(signupRequest.getPassword())
        );

        userRepository.save(user);

        return ResponseEntity.ok(
                new MessageResponse(
                        "User Register Success"
                )
        );
    }

}
