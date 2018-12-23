package com.ejogajog.services.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejogajog.entities.User;
import com.ejogajog.repositories.UserRepository;
import com.ejogajog.services.UserService;
import com.ejogajog.utils.ExceptionPreconditions;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public User getByEmail(String email) {
		User user = userRepository.findByEmail(email);
		ExceptionPreconditions.checkFound(user, User.class, "email", email.toString());
		return user;
	}
	
}
