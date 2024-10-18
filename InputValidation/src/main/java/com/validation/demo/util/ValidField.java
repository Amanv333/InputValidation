package com.validation.demo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // Can be applied to fields
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
public @interface ValidField {
    String message() default "Invalid value";
}

