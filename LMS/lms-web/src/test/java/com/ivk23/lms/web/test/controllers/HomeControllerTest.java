package com.ivk23.lms.web.test.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ivk23.lms.web.controllers.HomeController;

public class HomeControllerTest {
	
	// Oh Spring, what are you doing...
	@Test
	public void testIndex() throws Exception {
		HomeController hc = new HomeController();
		
		MockMvc mock = MockMvcBuilders.standaloneSetup(hc).build();
		
		mock.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.view().name("index"));
	}

}
