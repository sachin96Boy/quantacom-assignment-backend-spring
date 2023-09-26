package dev.sachin96boy.employbend.security.services;

import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel user = userRepository.findByuserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"+userName));

        return UserDetailsImpl.build(user);
    }
}
