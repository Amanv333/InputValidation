package com.validation.demo.util;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HtmlValidator implements ConstraintValidator<InputValidator, String> {

    private InputValidValues expectedValue;

    @Override
    public void initialize(InputValidator constraintAnnotation) {
        // Retrieve the value from the annotation
        this.expectedValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Return true if the field is optional; use @NotNull if required
        }

        switch (expectedValue) {
            case HTML_VALIDATE:
                // Remove HTML tags using regex
                if (Pattern.compile("<[^>]+>\\s+(?=<)|<[^>]+>").matcher(value).find()) {
                    return false; // Invalid if HTML tags are found
                }
                return true;
               

            case ALPHA_NUMERIC:
                if (Pattern.compile("^[a-zA-Z0-9 ]+$").matcher(value).find()) {
                    return true; // Valid if it matches the alphanumeric pattern
                }
                return false; // Invalid if it does not match

            // You can add more cases as needed

            default:
                // Handle the case when expectedValue does not match any known validation
                return true;
        }
    }
}
