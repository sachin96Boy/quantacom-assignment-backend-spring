package dev.sachin96boy.employbend.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sachin96boy.employbend.models.UserModel;
import dev.sachin96boy.employbend.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsImpl implements UserDetails {


    private String id;
    private String userName;
    private String userEmail;

    private UserType userType;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(UserModel user){

        return new UserDetailsImpl(
                user.getId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserType(),
                user.getPassword(),
                null
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
