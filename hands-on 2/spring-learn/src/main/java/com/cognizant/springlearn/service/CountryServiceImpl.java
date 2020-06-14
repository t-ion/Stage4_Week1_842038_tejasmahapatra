package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
@Service
public class CountryServiceImpl implements CountryService {
//	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	
	@SuppressWarnings("unchecked")
	List<Country> countryList= (List<Country>) context.getBean("countryList",java.util.ArrayList.class);
	
	@Override
	public Country getCountry(String code) throws CountryNotFoundException {
		for(Country c:countryList) {
			if(c.getCode().equalsIgnoreCase(code)) {
				return c;
			}
		}
		throw new CountryNotFoundException("constuctor of exception");
	}

}
