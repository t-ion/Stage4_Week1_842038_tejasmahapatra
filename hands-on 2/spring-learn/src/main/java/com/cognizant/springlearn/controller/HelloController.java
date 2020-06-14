package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.CountryServiceImpl;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	public HelloController() {
		LOGGER.info("Inside Constructor of controller");
	}

	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		LOGGER.info("end");
		return "hello world";
	}

	@RequestMapping("/country")
	@ResponseBody
	public Country getCountryIndia() {
		
		Country country = (Country) context.getBean("in", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		((AbstractApplicationContext) context).close();
		return country;
	}

	@GetMapping("/countries")
	@ResponseBody
	public List<Country> getAllCountries() {
	
		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList", java.util.ArrayList.class);
		((AbstractApplicationContext) context).close();
		return countries;
	}

	@GetMapping("/countries/{code}")
	@ResponseBody
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException{
		LOGGER.info("Start get country :"+code);
		CountryService countryService=new CountryServiceImpl();
		return countryService.getCountry(code);
	}
	/*
	 * public Country getCountry(@PathVariable String code) throws CountryNotFoundException{
		LOGGER.info("Start get country "+code);
		CountryService countryService=new CountryServiceImpl();
		Country country=null;
		try {
		country=countryService.getCountry(code);
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
			throw e;
		}
		return country;
	}*/
}