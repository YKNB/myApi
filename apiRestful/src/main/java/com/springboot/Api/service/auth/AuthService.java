package com.springboot.Api.service.auth;

import com.springboot.Api.dto.user.RegisterDto;
import com.springboot.Api.dto.auth.LoginDto;
import com.springboot.Api.dto.auth.LoginResponseDto;
import com.springboot.Api.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AuthService {

    ResponseEntity<LoginResponseDto> login(LoginDto dto);
    ResponseEntity<String> register(RegisterDto dto);
    void createRole(Role role);
    Optional<Role> findByRole(String roleType);
    void addRoleToUser(String email, String roleType);

}
