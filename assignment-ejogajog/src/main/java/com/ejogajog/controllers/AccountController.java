package com.ejogajog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejogajog.dtos.mapper.UserMapper;
import com.ejogajog.dtos.request.entities.UserRequestDto;
import com.ejogajog.dtos.response.entities.UserResponseDto;
import com.ejogajog.entities.User;
import com.ejogajog.exceptions.DuplicateResourceFoundException;
import com.ejogajog.exceptions.ResourceNotFoundException;
import com.ejogajog.services.UserService;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseController {

	private UserService userService;
	private UserMapper userMapper;
	private PasswordEncoder userPasswordEncoder;

	@Autowired
	public AccountController(UserService userService, UserMapper userMapper, PasswordEncoder userPasswordEncoder) {
		this.userService = userService;
		this.userMapper = userMapper;
		this.userPasswordEncoder = userPasswordEncoder;
	}

	@GetMapping("")
	public List<UserResponseDto> getAll() {
		return userMapper.getResponseDtos(userService.getAll());
	}

	@PostMapping("/sign-up")
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponseDto createUser(@Valid @RequestBody UserRequestDto requestDto) {
		this.checkDuplicateEmail(requestDto.getEmail());
		User user = userMapper.getEntity(requestDto);
		user.setPassword(userPasswordEncoder.encode(user.getPassword()));
		userService.save(user);
		return userMapper.getResponseDto(user);
	}

	private void checkDuplicateEmail(String email) {
		try {
			userService.getByEmail(email);
			throw new DuplicateResourceFoundException(User.class, "email", email);
		} catch (ResourceNotFoundException e1) {
		}
	}

}
