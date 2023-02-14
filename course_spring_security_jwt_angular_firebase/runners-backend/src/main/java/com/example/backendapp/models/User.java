package com.example.backendapp.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
// kombinacijata od ovie dve koloni e unikatna za sekoja redica
// Ne sme da ima dve redici so username:rusimka, email:rusimka
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max=120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name="role_id"))
    // lazy type - roles for the user will load only if getRoles() method is called
    // eager type - when loading all User information it will also load roles too
    // JoinTable - table for storing many to many objects
    // @JoinColumn - foreign key in the table
    // join column - owning side of the relationship and that is the class User
    // inverseJoinColumns - inverse side of the relationship

    private Set<Role> roles = new HashSet<>();

    private boolean isModerator; // this is important because we are adding role_moderator to some users


    public User(){}

    public User(Long userId, String username, String email, String password, boolean isModerator) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isModerator = isModerator;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }


}
