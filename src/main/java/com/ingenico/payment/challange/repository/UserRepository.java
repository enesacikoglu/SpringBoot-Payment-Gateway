package com.ingenico.payment.challange.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ingenico.payment.challange.entity.security.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);

	List<User> findAll();
}
