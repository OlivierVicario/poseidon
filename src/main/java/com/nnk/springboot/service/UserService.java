package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	public User saveUser(User user) {	
		userRepo.save(user);
		return user;
	}
	
	public Optional<User> getUserById(Integer id) {
		return userRepo.findById(id);
	}
	
	public User updateUser(User _user) {	
		Optional<User> optUser = getUserById(_user.getId());
		User updateUser = optUser.get();
		updateUser.setFullname(_user.getFullname());
		updateUser.setPassword(_user.getPassword());
		updateUser.setRole(_user.getRole());
		updateUser.setUsername(_user.getUsername());
		userRepo.save(updateUser);
		return updateUser;
	}
	
	public User deleteUser(int id) {
		User deleteUser = userRepo.getById( id);
		userRepo.delete(deleteUser);
		
		return deleteUser;
		
	}
}

