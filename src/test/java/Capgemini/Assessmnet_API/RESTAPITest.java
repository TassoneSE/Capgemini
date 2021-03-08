package Capgemini.Assessmnet_API;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class RESTAPITest  extends AssessmnetApiApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Test's to see if the expected JSON file is returned
	 * @throws Exception
	 */
	@Test
	public void testFourNumbers() throws Exception {
		mockMvc.perform(get("/data?numbers=5,4,6,1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.output").value(8.77))
				;


	}
	
	/**
	 * Will test to ensure two or less number will not be accepted.
	 * @throws Exception
	 */
	@Test
	public void testTwoNumbers() throws Exception {
		mockMvc.perform(get("/data?numbers=5,4")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.Error").value("Needs to be three or more numeric inputs"))
				;


	}
}
