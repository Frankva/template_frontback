package ch.sectioninformatique.template.user;

import ch.sectioninformatique.template.security.Role;

import java.util.Date;

public class UserBuilder {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private Role role;

    public UserBuilder() {
    }

    public UserBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UserBuilder setRole(Role role) {
        this.role = role;
        return this;
    }
    
    public User build() {
        return new User(this.id, this.firstName, this.lastName, this.email,
            this.password, this.createdAt, this.updatedAt, this.role);
    }
}
