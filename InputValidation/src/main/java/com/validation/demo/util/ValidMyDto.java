package com.validation.demo.util;

import jakarta.validation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MyValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMyDto {
    String message() default "Invalid DTO";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

