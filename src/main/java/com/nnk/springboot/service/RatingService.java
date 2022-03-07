package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;

import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	RatingRepository ratingRepo;

	public List<Rating> findAllRatings() {
		return ratingRepo.findAll();
	}

	public Rating saveRating(Rating rating) {
		ratingRepo.save(rating);
		return rating;
	}

	public Optional<Rating> getRatingById(Integer integer) {
		return ratingRepo.findById(integer);
	}

	public Rating updateRating(Rating _rating) {
		Optional<Rating> optrating = getRatingById(_rating.getId());
		Rating updateRating = optrating.get();
		updateRating.setMoodysRating(_rating.getMoodysRating());
		updateRating.setSandPRating(_rating.getSandPRating());
		updateRating.setFitchRating(_rating.getFitchRating());
		updateRating.setOrderNumber(_rating.getOrderNumber());
		ratingRepo.save(updateRating);
		return updateRating;
	}

	public Rating deleteRating(int id) {
		Rating deleteRating = ratingRepo.getById((id));
		ratingRepo.delete(deleteRating);

		return deleteRating;

	}
}
