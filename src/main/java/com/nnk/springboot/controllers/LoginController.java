package com.nnk.springboot.controllers;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nnk.springboot.repositories.UserRepository;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserRepository userRepository;

	@GetMapping("login")
	public String login() {
		try {
			LOGGER.info("begin login");
			
			
	        return "login";
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
	
	@GetMapping("logout")
	public String logout() {
		try {
			LOGGER.info("begin logout");
			SecurityContextHolder.getContext().setAuthentication(null);
			return "login";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end logout");
		}
		return null;
	}
}
