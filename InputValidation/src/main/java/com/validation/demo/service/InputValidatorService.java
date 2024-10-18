package com.validation.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.validation.demo.ExceptionHandler.InputException;
import com.validation.demo.entity.Person;

import jakarta.validation.Valid;



@Service
@Validated
public class InputValidatorService {
	
	public String validateInput(@Valid Person person) {
		
		System.out.println(person.getEmail());
		System.out.println(person.getMessage());
		return "success";
	}

}
