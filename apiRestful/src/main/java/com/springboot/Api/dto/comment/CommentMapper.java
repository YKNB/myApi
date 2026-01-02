package com.springboot.Api.dto.comment;


import com.springboot.Api.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment dtoToEntity(CommentDto dto);
    CommentDto entityToDto(Comment comment);

}
