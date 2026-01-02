package com.springboot.Api.controller;

import com.springboot.Api.dto.user.UserDto;
import com.springboot.Api.dto.user.UserResponse;
import com.springboot.Api.entity.UserPage;
import com.springboot.Api.repository.UserRepository;
import com.springboot.Api.service.user.UserService;
import com.springboot.Api.entity.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
@AllArgsConstructor
@RequestMapping("/api")
@Tag(name = "User")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping(value = "/user/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PutMapping(path="/user/{id}")
    public UserResponse updateById(@RequestBody UserDto userRequest, @PathVariable Long id){
        return userService.updateById(userRequest, id);
    }

    @GetMapping(path = "/users")
    public Page<UserResponse> getAll(UserPage userPage){
        return userService.getAll(userPage);
    }

    @Transactional
    @DeleteMapping("/user/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userRepository.deleteUsersById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
