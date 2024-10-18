package com.validation.demo.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class FieldValidationAspect {

    @Around("execution(* *(.., @ValidField (*), ..))") // Intercepts methods with any parameter annotated with @ValidField
    public Object validateFields(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // Loop through method parameters
        for (Object arg : args) {
            // Validate each field in the object
            if (arg != null) {
                validateObject(arg);
            }
        }

        return joinPoint.proceed(); // Proceed with method execution
    }

    private void validateObject(Object obj) throws IllegalArgumentException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidField.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    // Custom validation logic here
                    if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                        String message = field.getAnnotation(ValidField.class).message();
                        throw new IllegalArgumentException(message);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
