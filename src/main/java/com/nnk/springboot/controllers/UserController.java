package com.nnk.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/user/list")
	public String listUsers(Model model) {
		try {
			LOGGER.info("begin listUsers");
			List<User> users = userService.findAllUsers();
			model.addAttribute("users", users);
			return "user/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end listUsers");
		}
		return null;
	}

	@GetMapping("/user/add")
	public String addUser(@Valid User user, BindingResult bindingResult) {
		try {
			LOGGER.info("begin addUser");
			return "user/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end addUser");
		}
		return null;
	}

	@PostMapping("/user/validate")
	public String validate(@Valid User user, BindingResult result, Model model) {
		try {
			LOGGER.info("begin user validate");
			if (result.hasErrors()) {
	            return "user/add";
	        } else {
	        	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				user.setPassword(encoder.encode(user.getPassword()));
	        	userService.saveUser(user);
	        }
			return "redirect:/user/list";
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end user validate");
		}
		
		return null;
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin showUpdateForm");
			Optional<User> optUser = userService.getUserById(id);
			User user = optUser.get();
			user.setPassword("");
			model.addAttribute("user", user);
			return "user/update";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end showUpdateForm");
		}
		return null;
	}

	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model) {
		try {
			LOGGER.info("begin updateUser");
			if (result.hasErrors()) {
				return "user/update";
			}

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setId(id);
			userService.saveUser(user);
			model.addAttribute("users", userService.findAllUsers());
			return "redirect:/user/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end updateUser");
		}
		return null;
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin deleteUser");
			userService.deleteUser(id);
			model.addAttribute("users", userService.findAllUsers());
			return "redirect:/user/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end deleteUser");
		}
		return null;
	}
}
