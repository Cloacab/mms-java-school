package com.yuri.mmsjavaschool.models.validators;

import com.yuri.mmsjavaschool.models.dto.ClientDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        ClientDto client = (ClientDto) o;
        return true;
//        return client.getPassword().equals(client.getMatchingPassword());
    }
}
