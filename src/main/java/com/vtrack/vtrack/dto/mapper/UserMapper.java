package com.vtrack.vtrack.dto.mapper;

import com.vtrack.vtrack.dto.UserDto;
import com.vtrack.vtrack.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}