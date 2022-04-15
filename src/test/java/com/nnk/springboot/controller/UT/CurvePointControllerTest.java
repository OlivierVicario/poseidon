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

import com.nnk.springboot.controllers.CurvePointController;

@SpringBootTest
@AutoConfigureMockMvc
public class CurvePointControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CurvePointController curvePointController;
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnHome_shouldSucceedWith200() throws Exception{
		this.mockMvc.perform(get("/curvePoint/list")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnaddBidForm_shouldSucceedWith200() throws Exception{
		this.mockMvc.perform(get("/curvePoint/add")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnShowUpdateForm_shouldClientErrorWith404() throws Exception{
		this.mockMvc.perform(get("/curvePoint/update?id=2")).andExpect(status().is4xxClientError());
	}
	
	@WithMockUser(value = "spring")
	@Test
	public void givenAuthRequestOnDeleteCurvePoint_shouldClientErrorWith404() throws Exception{
		this.mockMvc.perform(get("/curvePoint/delete?id=2")).andExpect(status().is4xxClientError());
	}
}
