package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "Please provide username.")
    @Size(min = 5, max = 15, message = "Please create a username with 5 - 15 characters.")
    private String username;

    @Email(message = "Email not valid.")
    private String email;

    @NotBlank(message = "Please provide password.")
    @Size(min = 3, message = "Password must be at minimum 6 characters.")
    private String password;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
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
}
