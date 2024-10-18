package com.validation.demo.util;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Value;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpecialCharValidator implements ConstraintValidator<ValidateSpecialCharacter, String>{
	
	@Value("${valid.special-character}")
	private String special_characters;
	
	
    private String regex;

    @Override
    public void initialize(ValidateSpecialCharacter constraintAnnotation) {
        // Initialize the regex after the special_characters is injected
        regex = "^[a-zA-Z0-9" + Pattern.quote(special_characters) + " ]+$";
    }
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Return true if the field is optional; use @NotNull if required
        }

        // Remove HTML tags using regex
     //   if(Pattern.compile(regex).matcher(value).find()) {
        if(Pattern.compile(regex).matcher(value).find()) {
        	return true;
        }
        return false;
    }
	

}

//if (input == null) {
//    return false; // Return false if input is null
//}
//
//// Create a regex pattern to match allowed characters (letters, digits, spaces, and allowed special characters)
//String regex = "^[a-zA-Z0-9" + Pattern.quote(allowedSpecialChars) + " ]+$";
//
//return input.matches(regex); // Check if the input matches the regex pattern
//}
