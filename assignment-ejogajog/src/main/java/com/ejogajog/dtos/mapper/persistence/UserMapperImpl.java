package com.ejogajog.dtos.mapper.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ejogajog.dtos.mapper.UserMapper;
import com.ejogajog.dtos.request.entities.UserRequestDto;
import com.ejogajog.dtos.response.entities.UserResponseDto;
import com.ejogajog.entities.User;

@Component
@Scope(value = "prototype")
public class UserMapperImpl extends RequestResponseDtoMapperImpl<User, UserResponseDto, UserRequestDto>
		implements UserMapper {

	protected UserMapperImpl(ModelMapper modelMapper) {
		super(modelMapper, UserResponseDto.class, User.class);
	}

}
