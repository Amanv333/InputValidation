package com.validation.demo.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class MyValidator implements ConstraintValidator<ValidMyDto, Object> {

	private static final String HTML_TAG_PATTERN = "<[^/!][^>]*>";

	@Override
	public boolean isValid(Object dto, ConstraintValidatorContext context) {
		if (dto == null) {
			return true; // Handle null according to your needs
		}

		boolean isValid = true;
		StringBuilder violationMessages = new StringBuilder();

		// Iterate through fields of the DTO
		for (Field field : dto.getClass().getDeclaredFields()) {
			field.setAccessible(true); // Allow access to private fields
			try {
				Object value = field.get(dto);

				// Example validation: check if the field is null
				if (value instanceof String) {
					// Validate string fields against the HTML tag pattern
					if (Pattern.compile(HTML_TAG_PATTERN).matcher((String) value).find()) {
						isValid = false;
						violationMessages.append(field.getName()).append(" must not contain HTML tags; ");
					}
				}

			

			} catch (IllegalAccessException e) {
				// Handle exception if needed
				e.printStackTrace();
			}
		}

		if (!isValid) {
			context.buildConstraintViolationWithTemplate(violationMessages.toString().trim()).addConstraintViolation();
		}

		return isValid;
	}
}
