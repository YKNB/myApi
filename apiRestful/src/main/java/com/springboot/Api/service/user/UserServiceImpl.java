package com.springboot.Api.service.user;

import com.springboot.Api.dto.user.UserDto;
import com.springboot.Api.dto.user.UserResponse;
import com.springboot.Api.entity.User;
import com.springboot.Api.entity.UserPage;
import com.springboot.Api.exception.ResourceNotFoundException;
import com.springboot.Api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email:" + email)
        );
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id:" + id)
        );
    }

    public Page<UserResponse> getAll(UserPage userPage) {
        Sort sort = Sort.by(userPage.getSortDirection(), userPage.getSortBy());
        Pageable pageable = PageRequest.of(userPage.getPageNumber(),
                userPage.getPageSize(), sort);
        return userRepository.findAll(pageable).map(UserResponse::of);
    }

    private User getEntityById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public UserResponse updateById(UserDto userRequest, Long id) {
        var user = userRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("User", "id", id));
        BeanUtils.copyProperties(userRequest, user);
        return UserResponse.of(userRepository.save(user));
    }
}
