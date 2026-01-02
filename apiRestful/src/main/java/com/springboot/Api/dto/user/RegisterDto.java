package com.springboot.Api.dto.user;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class RegisterDto {

    @NotEmpty(message = "Username is required!")
    private String username;

    @NotEmpty(message = "Pseudo is required!")
    private String pseudo;

    @NotEmpty(message = "Email is required!")
    @Email(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Email must be a well-formed email address!")
    private String email;


    @NotEmpty
    @NotEmpty(message = "Password is required!")
    private String password;


    private void setPseudo(String pseudo) {
        this.pseudo = pseudo.trim();
    }

    private void setEmail(String email) {
        this.email = email.toLowerCase().trim();
    }

    private void setUsername(String username) {
        this.username = username.trim();
    }
}
