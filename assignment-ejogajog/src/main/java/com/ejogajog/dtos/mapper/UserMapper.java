package com.ejogajog.dtos.mapper;

import com.ejogajog.dtos.request.entities.UserRequestDto;
import com.ejogajog.dtos.response.entities.UserResponseDto;
import com.ejogajog.entities.User;

public interface UserMapper extends RequestResponseDtoMapper<User, UserResponseDto, UserRequestDto> {

}
