package dev.sachin96boy.employbend.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sachin96boy.employbend.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsImpl implements UserDetails {

    private String id;
    private String userName;
    private String userEmail;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String id, String userName, String userEmail, String password) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public static UserDetailsImpl build(UserModel user){

        return new UserDetailsImpl(
                user.getId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getPassword()                
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
