package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model) {
		try {
			LOGGER.info("begin home");
			return "home";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end home");
		}

		return null;
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		try {
			LOGGER.info("begin adminHome");
			return "redirect:/bidList/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end adminHome");
		}

		return null;
	}

}
