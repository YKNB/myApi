package com.springboot.Api.dto.auth;

import lombok.Data;

import java.util.regex.Pattern;

@Data
public class LoginDto {

    private String login;
    private String password;

    public void setLogin(String login) {
        String emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        if (Pattern.compile(emailRegex).matcher(login).matches())
            this.login = login.toLowerCase();
        else
            this.login = login;
    }
}
