package com.vtrack.vtrack.validation;

import com.vtrack.vtrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueMobileNumberValidator implements ConstraintValidator<MobileNumberValidation, String> {
    @Autowired
    private UserService userService;


    @Override
    public void initialize(MobileNumberValidation constraintAnnotation) {
        // No-op
    }


    @Override
    public boolean isValid(String mobileNo, ConstraintValidatorContext context) {
        if(mobileNo == null){
            return true;
        }
        return !userService.mobileNoExists(mobileNo);
    }
}

