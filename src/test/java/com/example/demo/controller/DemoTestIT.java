package com.example.demo.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.base.IntegrationTestBase;

public class DemoTestIT extends IntegrationTestBase {

	@Test
	public void testEndpoint() throws Exception {

		String expectedContent = "Hello World";
		// @formatter:off
		mockMvc().perform(MockMvcRequestBuilders
								.get("/test"))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.content().string(
															Matchers.equalToCompressingWhiteSpace(expectedContent)));
		// @formatter:on

	}

}
