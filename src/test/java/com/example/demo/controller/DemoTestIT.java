package com.example.demo.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.base.IntegrationTestBase;
import com.example.demo.utils.TestFileUtils;

public class DemoTestIT extends IntegrationTestBase {

	private final String fileSourcePath = "payloads/test-json.json";

	@Test
	public void testStringEndpoint() throws Exception {

		String expectedContent = "Hello World";
		// @formatter:off
		mockMvc().perform(MockMvcRequestBuilders
								.get("/test"))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.content().string(
															Matchers.equalToCompressingWhiteSpace(expectedContent)));
		// @formatter:on

	}

	@Test
	public void testJsonEndpoint() throws Exception {

		// @formatter:off
		String expectedContent = TestFileUtils.getFileContentAsString(fileSourcePath);
				
		mockMvc().perform(MockMvcRequestBuilders
								.get("/testJson"))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.content().string(
															Matchers.equalToCompressingWhiteSpace(expectedContent)));
		// @formatter:on

	}

}
