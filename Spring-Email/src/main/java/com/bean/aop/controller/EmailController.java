package com.bean.aop.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.aop.model.Person;
import com.bean.aop.proxy.PersonJ;
import com.bean.aop.service.EmailService;


@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@Autowired
	Properties properties;
	
	@RequestMapping("/send")
	public String send() {
		
		emailService.sendEmail();
		Person person=new Person();
		person.setContact(properties.getProperty("contact"));
		person.setEmail(properties.getProperty("email"));
		person.setName( properties.getProperty("name"));
		person.setId(Integer.parseInt(properties.getProperty("id")));
//		emailService.save(person);
		System.out.println(person);
		emailService.save(person);
		
//		Person p=emailService.findById(1).get();
//		System.out.println(p.getEmail());
		
		return "email has been sent";
	}
}