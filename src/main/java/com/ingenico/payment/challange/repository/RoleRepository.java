package com.ingenico.payment.challange.repository;

import org.springframework.data.repository.CrudRepository;

import com.ingenico.payment.challange.entity.security.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}
