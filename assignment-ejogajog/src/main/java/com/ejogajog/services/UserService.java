package com.ejogajog.services;

import com.ejogajog.entities.User;


public interface UserService {

	User save(User user);

	Iterable<User> getAll();

	User getByEmail(String email);
	
}
