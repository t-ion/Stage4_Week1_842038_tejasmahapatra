package com.cognizant.springlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayCountry() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Country : {}", anotherCountry.toString());
		((AbstractApplicationContext) context).close();
	}
	
	@SuppressWarnings("unchecked")
	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList", java.util.ArrayList.class);
		for(Country c:countries)
			LOGGER.debug("Country : {}", c.toString());
		((AbstractApplicationContext) context).close();
		LOGGER.info("END");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
//		displayCountry();
		displayCountries();
	}

}
