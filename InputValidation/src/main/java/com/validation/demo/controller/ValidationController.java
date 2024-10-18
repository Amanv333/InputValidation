package com.validation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.validation.demo.dto.MyDto;
import com.validation.demo.entity.Person;
import com.validation.demo.service.InputValidatorService;
import com.validation.demo.util.InputSanitizer;
import com.validation.demo.util.InputSanitizer1;

import jakarta.validation.Valid;




@RestController
public class ValidationController {
	@Autowired
	private InputValidatorService inputValidatorService;
	
	@PostMapping("/person")
	public String validate(@RequestBody Person person,BindingResult result) {
		String messageInput = InputSanitizer.sanitize(person.getMessage());
		person.setMessage(messageInput);
		return inputValidatorService.validateInput(person);
		

	}
	
	@PostMapping("/person2")
	public String validate2(@RequestBody Person person) {
		InputSanitizer1.validateInput(person.getMessage());
		return inputValidatorService.validateInput(person);
		
	}
	
	@PostMapping("/dto")
	public String validate2(@RequestBody @Valid MyDto dto) {
		
		return dto.getName();
		
	}
	
	

}
