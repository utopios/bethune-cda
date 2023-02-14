package com.example.backendapp.security.services;

// In this object there are options for getting the username password, id, and so on
import com.example.backendapp.models.User;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// this class contains all informations about user , username , email, password and so on
// this object we use to make an authentication object
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String email;

    @JsonIgnore // if the field is null
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long userId, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role-> new SimpleGrantedAuthority((role.getRoleName().name())))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    // The Set<Role> is turned into List<GrantedAuthrieties> and maps every role into simple granted authroies


    // all of these loads the user authenticated user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) obj;
        return Objects.equals(userId, user.userId);
    }
}
