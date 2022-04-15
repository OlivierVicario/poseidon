package com.nnk.springboot.service.UT;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.RatingService;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

	@Mock
	private RatingRepository ratingRepository;
	
	@Autowired
	@InjectMocks
	private RatingService ratingService;
	
	private Rating rating1;
	private Rating rating2;
	List<Rating> ratings;

	@BeforeEach
	public void SetUp() {
		ratings = new ArrayList<>();
		rating1 = new Rating();
		rating1.setId(1);
		rating1.setFitchRating("fitch");
		rating1.setMoodysRating("moody");
		rating1.setSandPRating("sand");
		rating1.setOrderNumber(5);
		ratings.add(rating1);
		
		rating2 = new Rating();
		rating2.setId(2);
		rating2.setFitchRating("fitch");
		rating2.setMoodysRating("moody");
		rating2.setSandPRating("sand");
		rating2.setOrderNumber(5);
		ratings.add(rating2);
		
		
	}
	@AfterEach
    public void tearDown() {
    rating1 = rating2 = null;
    ratings = null;
    }
	
	@Test
	void givenRatingToAddShouldReturnAddedRating(){
	     
	     when(ratingRepository.save(any())).thenReturn(rating1);
	     ratingService.saveRating(rating1);
	     verify(ratingRepository,times(1)).save(any());
	}
	
	@Test
	public void GivenGetAllRatingsShouldReturnListOfAllRatings(){
	     ratingRepository.save(rating1);
	    
	    when(ratingRepository.findAll()).thenReturn(ratings);
	    List<Rating> ratings1 =ratingService.findAllRatings();
	    assertEquals(ratings1,ratings);
	    verify(ratingRepository,times(1)).save(rating1);
	    verify(ratingRepository,times(1)).findAll();
	}
	
	@Test
	public void GivenRatingToDeleteShouldReturnNull() {
		
	     ratingService.deleteRating(rating1.getId());
	     verify(ratingRepository,times(1)).delete(any());
	}
}


