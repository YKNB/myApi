package com.springboot.Api.service.user;

import com.springboot.Api.dto.user.UserDto;
import com.springboot.Api.dto.user.UserResponse;
import com.springboot.Api.entity.User;
import com.springboot.Api.entity.UserPage;
import org.springframework.data.domain.Page;

public interface UserService {

    User getById(Long id);

    User getUser(String email);

    UserResponse updateById(UserDto userRequest, Long id);

    Page<UserResponse> getAll(UserPage userPage);
}
