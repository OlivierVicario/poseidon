package com.nnk.springboot;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		return value.matches(PASSWORD_PATTERN);
	}

}
