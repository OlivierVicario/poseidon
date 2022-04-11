package com.nnk.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnk.springboot.domain.User;


public interface UserRepository extends JpaRepository<User, Integer>{//, JpaSpecificationExecutor<User> {
	User findByUsername(String username);
}
