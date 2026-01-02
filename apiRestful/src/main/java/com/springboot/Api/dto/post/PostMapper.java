package com.springboot.Api.dto.post;

import com.springboot.Api.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "comments", ignore = true)
    PostDto entityToDto(Post post);
    Post dtoToEntity(PostDto dto);
}
