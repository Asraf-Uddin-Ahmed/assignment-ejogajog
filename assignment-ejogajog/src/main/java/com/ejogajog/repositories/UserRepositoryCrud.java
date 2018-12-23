package com.ejogajog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ejogajog.entities.User;

@Transactional
public interface UserRepositoryCrud extends PagingAndSortingRepository<User, Long> {
	public User findByEmail(String email);
}
