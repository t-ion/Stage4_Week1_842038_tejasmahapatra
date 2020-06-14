package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

public interface CountryService{
	Country getCountry(String code) throws CountryNotFoundException;
}