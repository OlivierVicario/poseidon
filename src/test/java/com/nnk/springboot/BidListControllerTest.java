package com.nnk.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.nnk.springboot.controllers.BidListController;

@SpringBootTest
@AutoConfigureMockMvc
public class BidListControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	BidListController bidListController;
	
	@WithMockUser("user")
	@Test
	public void shouldReturnBidLists() throws Exception {
		this.mockMvc.perform(get("/bidList/list")).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString().contains("account0");
	}
	
	@WithMockUser("user")
	@Test
	public void shouldAddBidList() throws Exception {
		this.mockMvc.perform(get("/bidList/add")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldUpdateBidList() throws Exception {
		this.mockMvc.perform(get("/bidList/update/5")).andExpect(status().isOk());
				
	}
	/*
	@WithMockUser("user")
	@Test
	public void shouldDeleteBidList() throws Exception {
		this.mockMvc.perform(get("/bidList/delete/3")).andExpect(status().isOk());
				
	}
	*/
}
