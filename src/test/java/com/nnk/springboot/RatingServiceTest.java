package com.nnk.springboot;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RatingServiceTest {
	@Autowired
	private RatingService ratingService;
	
	@Test
	public void ratingTest() throws Exception{
		Rating rating = new Rating("moodysRating", "sandPRating", "fitchRating",5);

		// Save
		rating = ratingService.saveRating(rating);
		Integer id = rating.getId();
		Assertions.assertNotNull(rating.getId());
		Assertions.assertEquals(rating.getId(), id);
		
	
		// Update
		rating.setId(id);
		rating = ratingService.updateRating(rating);
		Assertions.assertEquals(rating.getId(),  id);
			
		// Find
		List<Rating> listResult = ratingService.findAllRatings();
		Assertions.assertTrue(listResult.size() > 0);
		
		// Delete
		id = rating.getId();
		ratingService.deleteRating(id.intValue());
		Optional<Rating> optRating = ratingService.getRatingById(id);
		Assertions.assertFalse(optRating.isPresent());

	}
}
