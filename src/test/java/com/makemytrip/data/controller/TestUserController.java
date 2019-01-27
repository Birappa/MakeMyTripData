package com.makemytrip.data.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserController {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() throws Exception{
		
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		
		mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
	}
	
	
}
