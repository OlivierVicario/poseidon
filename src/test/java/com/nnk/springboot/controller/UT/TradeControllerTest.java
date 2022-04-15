package com.nnk.springboot.controller.UT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.nnk.springboot.controllers.TradeController;

@SpringBootTest
@AutoConfigureMockMvc
public class TradeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	TradeController tradeController;
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnHome_shouldSucceedWith200() throws Exception{
		this.mockMvc.perform(get("/trade/list")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnaddBidForm_shouldSucceedWith200() throws Exception{
		this.mockMvc.perform(get("/trade/add")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnShowUpdateForm_shouldClientErrorWith404() throws Exception{
		this.mockMvc.perform(get("/trade/update?id=2")).andExpect(status().is4xxClientError());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnDeleteBid_shouldClientErrorWith404() throws Exception{
		this.mockMvc.perform(get("/trade/delete?id=2")).andExpect(status().is4xxClientError());
	}
}

