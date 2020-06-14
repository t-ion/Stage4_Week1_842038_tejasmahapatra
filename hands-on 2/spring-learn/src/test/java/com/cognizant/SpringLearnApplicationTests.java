package com.cognizant;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.controller.HelloController;
@AutoConfigureMockMvc
@SpringBootTest(classes= {com.cognizant.springlearn.SpringLearnApplication.class})
class SpringLearnApplicationTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@Autowired
    private HelloController countryController;
    @Autowired
    private MockMvc mvc;

	@Test
	void contextLoads() {
		LOGGER.info("contextLoads start");
		assertNotNull(countryController);
		LOGGER.info("contextloads end");
	}
	@Test
    public void testGetCountry() throws Exception {
		LOGGER.info("testgetcountry start");
        ResultActions actions = mvc.perform(get("/country"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        LOGGER.info("testgetcountry end");
    }
	/**
	 * @throws Exception
	 */
	@Test
    public void testGetCountryException()  throws Exception {
		LOGGER.info("testgetcountryexc start");
        ResultActions actions = mvc.perform(get("/countries/az"));
        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Country not found"));
//        actions.andExpect(status().reason("Country not found"));
        LOGGER.info("testgetcountryexc end");
    }
}
