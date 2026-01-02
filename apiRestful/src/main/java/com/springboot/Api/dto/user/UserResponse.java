package com.springboot.Api.dto.user;

import com.springboot.Api.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String pseudo;
    private String email;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .pseudo(user.getPseudo())
                .email(user.getEmail())
                .build();
    }
}
