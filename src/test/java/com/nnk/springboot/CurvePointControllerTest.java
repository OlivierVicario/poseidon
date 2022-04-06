package com.nnk.springboot;

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

import com.nnk.springboot.controllers.CurvePointController;

@SpringBootTest
@AutoConfigureMockMvc
public class CurvePointControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	CurvePointController curvePointController;
	
	@WithMockUser("user")
	@Test
	public void shouldReturnCurvePoints() throws Exception {
		this.mockMvc.perform(get("/curvePoint/list")).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString().contains("account0");
	}
	
	@WithMockUser("user")
	@Test
	public void shouldAddCurvePoint() throws Exception {
		this.mockMvc.perform(get("/curvePoint/add")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldUpdateCurvePoint() throws Exception {
		this.mockMvc.perform(get("/curvePoint/update/22")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldValidateBidList() throws Exception {
		this.mockMvc.perform(post("/curvePoint/validate").with(csrf())).andExpect(status().isOk());
				
	}
	/*
	@WithMockUser("user")
	@Test
	public void shouldDeleteCurvePoint() throws Exception {
		this.mockMvc.perform(get("/curvePoint/delete/31")).andExpect(status().isOk());
				
	}
	*/
}
