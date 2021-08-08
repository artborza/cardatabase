package com.packt.cardatabase.repository;

import org.springframework.data.repository.CrudRepository;

import com.packt.cardatabase.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
