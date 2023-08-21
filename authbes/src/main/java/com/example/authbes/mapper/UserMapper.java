package com.example.authbes.mapper;

import com.example.authbes.dto.UserDto;
import com.example.authbes.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper extends IEntityMapper<UserDto, User> {
}
