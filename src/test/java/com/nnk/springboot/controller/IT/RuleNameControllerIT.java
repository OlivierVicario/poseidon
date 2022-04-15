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

import com.nnk.springboot.controllers.RuleNameController;

@SpringBootTest
@AutoConfigureMockMvc
public class RuleNameControllerIT {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	RuleNameController ruleNameController;
	
	@WithMockUser("user")
	@Test
	public void shouldReturnRuleNames() throws Exception {
		this.mockMvc.perform(get("/ruleName/list")).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString().contains("name");
	}
	
	@WithMockUser("user")
	@Test
	public void shouldAddRuleName() throws Exception {
		this.mockMvc.perform(get("/ruleName/add")).andExpect(status().isOk());
				
	}
	
	@WithMockUser("user")
	@Test
	public void shouldUpdateRuleName() throws Exception {
		this.mockMvc.perform(get("/ruleName/update/15")).andExpect(status().isOk());
				
	}
	@WithMockUser("user")
	@Test
	public void shouldValidateBidList() throws Exception {
		this.mockMvc.perform(post("/ruleName/validate").with(csrf())).andExpect(status().isOk());
				
	}
	/*
	@WithMockUser("user")
	@Test
	public void shouldDeleteRuleName() throws Exception {
		this.mockMvc.perform(get("/ruleName/delete/3")).andExpect(status().isOk());
				
	}
	*/
}
