package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

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

import javax.validation.Valid;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/user/list")
	public String home(Model model) {
		try {
			LOGGER.info("begin home");
			model.addAttribute("users", userRepository.findAll());
			return "user/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end home");
		}
		return null;
	}

	@GetMapping("/user/add")
	public String addUser(User user) {
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
			LOGGER.info("begin validate");
			if (!result.hasErrors()) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				user.setPassword(encoder.encode(user.getPassword()));
				userRepository.save(user);
				model.addAttribute("users", userRepository.findAll());
				return "redirect:/user/list";
			}
			return "user/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end validate");
		}
		return null;
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin showUpdateForm");
			User user = userRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
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
			userRepository.save(user);
			model.addAttribute("users", userRepository.findAll());
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
			User user = userRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			userRepository.delete(user);
			model.addAttribute("users", userRepository.findAll());
			return "redirect:/user/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end deleteUser");
		}
		return null;
	}
}
