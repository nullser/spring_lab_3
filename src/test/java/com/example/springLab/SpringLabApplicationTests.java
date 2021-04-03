package com.example.springLab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SpringLabApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	void firstTest() throws Exception {
		this.mockMvc.perform(get("/Triangle?sideFirst=1&sideSecond=1&sideThird=2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{perimeter:4.0,square:0.0,triangleExist:true}"));
	}

	@Test
	void secondTest() throws Exception {
		this.mockMvc.perform(get("/Triangle?sideFirst=3&sideSecond=4&sideThird=5"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{perimeter:12.0,square:6.0,triangleExist:true}"));
	}

	@Test
	void thirdTest() throws Exception {
		this.mockMvc.perform(get("/Triangle?sideFirst=3&sideSecond=1&sideThird=5"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{perimeter:0.0,square:0.0,triangleExist:false}"));
	}
}