package com.validation.demo.util;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OnlyAlphaNumericValidator implements ConstraintValidator<OnlyAlphaNumeric, String>{
	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Return true if the field is optional; use @NotNull if required
        }

        //^[a-zA-Z]+$  ^[a-zA-Z0-9]+$
        // Remove HTML tags using regex
        if(Pattern.compile("^[a-zA-Z0-9]+$").matcher(value).find()) {
        	return true;
        }
        return false;
    }
	

}
