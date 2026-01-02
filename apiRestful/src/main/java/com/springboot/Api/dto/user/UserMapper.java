package com.springboot.Api.dto.user;

import com.springboot.Api.security.service.UserDetailsImpl;
import com.springboot.Api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    RegisterDto dtoToEntity(User user);
    User entityToDto(RegisterDto dto);
    @Mapping(target = "roles", ignore = true)
    UserDto userDetailsToUserDto(UserDetailsImpl user);

}
