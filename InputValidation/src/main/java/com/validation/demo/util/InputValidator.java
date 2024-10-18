package com.validation.demo.util;

import java.lang.annotation.*;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Constraint(validatedBy = HtmlValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InputValidator {
	
	InputValidValues value();
    
	String message() default "Invalid Field"; // Default error message

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
