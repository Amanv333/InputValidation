package com.validation.demo.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Documented
@Constraint(validatedBy = SpecialCharValidator.class)
@Target(ElementType.FIELD) // Can be applied to fields
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
public @interface ValidateSpecialCharacter {
    String message() default "Invalid character present in the input";
    Class<?>[] groups() default {}; // This is where you include the groups parameter

    Class<? extends Payload>[] payload() default {};
}

