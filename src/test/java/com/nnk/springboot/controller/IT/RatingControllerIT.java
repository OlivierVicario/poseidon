package com.nnk.springboot.controller.IT;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.nnk.springboot.controllers.RatingController;

@SpringBootTest
@AutoConfigureMockMvc
public class RatingControllerIT {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	RatingController ratingController;
	
	@WithMockUser("user")
	@Test
	public void shouldReturnRatings() throws Exception {
		this.mockMvc.perform(get("/rating/list")).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString().contains("account0");
	}
	
	@WithMockUser("user")
	@Test
	public void shouldAddRating() throws Exception {
		this.mockMvc.perform(get("/rating/add")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldUpdateRating() throws Exception {
		this.mockMvc.perform(get("/rating/update/2")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldValidateBidList() throws Exception {
		this.mockMvc.perform(post("/rating/validate").with(csrf())).andExpect(status().isOk());
				
	}
	/*
	@WithMockUser("user")
	@Test
	public void shouldDeleteRating() throws Exception {
		this.mockMvc.perform(get("/rating/delete/3")).andExpect(status().isOk());
				
	}
	*/
}
