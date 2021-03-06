package com.nnk.springboot.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
	String message() default "Password must include at least one capital letter, at least 8 characters, at least one number and one symbol.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
