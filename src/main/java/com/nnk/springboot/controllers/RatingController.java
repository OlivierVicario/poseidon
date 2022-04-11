package com.nnk.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;

@Controller
public class RatingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RatingController.class);
	
	@Autowired
	RatingService ratingService;

	@RequestMapping("/rating/list")
	public String home(Model model) {
		try {
			LOGGER.info("begin home");
			
			List<Rating> ratings = ratingService.findAllRatings();
			model.addAttribute("ratings", ratings);
			return "rating/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end home");
		}

		return null;
	}

	@GetMapping("/rating/add")
	public String addRatingForm(Rating rating) {

		try {
			LOGGER.info("begin addRatingForm");
			return "rating/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end addRatingForm");
		}

		return null;
	}

	@PostMapping("/rating/validate")
	public String validate(@Valid Rating rating, BindingResult result, Model model) {
		try {
			LOGGER.info("begin validate");
			
			if (result.hasErrors()) {
				return "rating/add";
			} else {
				ratingService.saveRating(rating);
			}
			return "rating/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end validate");
		}

		return null;
	}

	@GetMapping("/rating/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin showUpdateForm");
			
			Optional<Rating> optRating = ratingService.getRatingById(id);
			Rating rating = optRating.get();
			model.addAttribute("rating", rating);
			return "rating/update";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end showUpdateForm");
		}

		return null;
	}

	@PostMapping("/rating/update/{id}")
	public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating, BindingResult result,
			Model model) {
		try {
			LOGGER.info("begin updateRating");
			// TODO: check required fields, if valid call service to update Rating and
			// return Rating list
			if (result.hasErrors()) {
				return "rating/update/{id}";
			} else {
				ratingService.updateRating(rating);
			}
			return "redirect:/rating/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end updateRating");
		}

		return null;
	}

	@GetMapping("/rating/delete/{id}")
	public String deleteRating(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin deleteRating");
			// TODO: Find Rating by Id and delete the Rating, return to Rating list
			ratingService.deleteRating(id);
			return "redirect:/rating/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end deleteRating");
		}

		return null;
	}
}
