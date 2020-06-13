package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
public static void displayDate() {
	ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
	 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
	 Date date;
	try {
		date = format.parse("31/12/2018");
		System.out.println("Date: "+date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		System.out.println("hello world");
		displayDate();
	}

}
