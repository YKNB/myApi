package com.springboot.Api.dto.user;

import com.springboot.Api.entity.Role;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;


@Data
public class UserDto {

    private Long id;
    private String username;
    private String pseudo;
    private String email;
  //  private String password;
    private Set<String> roles;


    public void setRoles(Set<Role> roles) {
        this.roles = roles.stream().map(Role::getRole).collect(Collectors.toSet());
    }

}
