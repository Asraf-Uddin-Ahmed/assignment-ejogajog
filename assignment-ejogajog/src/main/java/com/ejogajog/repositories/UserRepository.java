package com.ejogajog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ejogajog.entities.User;

@Transactional
public interface UserRepository extends UserRepositoryCrud, JpaSpecificationExecutor<User> {

}
