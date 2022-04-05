package com.nnk.springboot.controllers;

import com.nnk.springboot.repositories.UserRepository;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("app")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserRepository userRepository;

	@GetMapping("login")
	@RolesAllowed("USER")
	public ModelAndView login() {
		try {
			LOGGER.info("begin login");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			return mav;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end login");
		}

		return null;
	}

	@GetMapping("secure/article-details")
	@RolesAllowed("ADMIN")
	public ModelAndView getAllUserArticles() {
		try {
			LOGGER.info("begin getAllUserArticles");

			ModelAndView mav = new ModelAndView();
			mav.addObject("users", userRepository.findAll());
			mav.setViewName("user/list");
			return mav;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end getAllUserArticles");
		}

		return null;
	}

	@GetMapping("error")
	public ModelAndView error() {

		try {
			LOGGER.info("begin error");
			ModelAndView mav = new ModelAndView();
			String errorMessage = "You are not authorized for the requested data.";
			mav.addObject("errorMsg", errorMessage);
			mav.setViewName("403");
			return mav;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end error");
		}

		return null;
	}
	
	@GetMapping("app-logout")
	public String showLoginForm() {
		return "login";
	}
	
	
}
