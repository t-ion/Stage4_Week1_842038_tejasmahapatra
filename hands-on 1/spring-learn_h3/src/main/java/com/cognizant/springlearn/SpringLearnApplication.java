package com.cognizant.springlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
public static void displayDate() {
	ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
	 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
	 Date date;
	try {
		LOGGER.info("START");
		date = format.parse("31/12/2018");
	    LOGGER.debug(date.toString());
	    LOGGER.info("END");

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}

}
