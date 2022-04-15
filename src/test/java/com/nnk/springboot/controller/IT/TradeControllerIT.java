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

import com.nnk.springboot.controllers.TradeController;

@SpringBootTest
@AutoConfigureMockMvc
public class TradeControllerIT {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	TradeController tradeController;
	
	@WithMockUser("user")
	@Test
	public void shouldReturnTrades() throws Exception {
		this.mockMvc.perform(get("/trade/list")).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString().contains("account0");
	}
	
	@WithMockUser("user")
	@Test
	public void shouldAddTrade() throws Exception {
		this.mockMvc.perform(get("/trade/add")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldUpdateTrade() throws Exception {
		this.mockMvc.perform(get("/trade/update/16")).andExpect(status().isOk());
				
	}
	@WithMockUser("user")
	@Test
	public void shouldValidateBidList() throws Exception {
		this.mockMvc.perform(post("/trade/validate").with(csrf())).andExpect(status().isOk());
				
	}
	/*
	@WithMockUser("user")
	@Test
	public void shouldDeleteTrade() throws Exception {
		this.mockMvc.perform(get("/trade/delete/3")).andExpect(status().isOk());
				
	}
	*/
}
