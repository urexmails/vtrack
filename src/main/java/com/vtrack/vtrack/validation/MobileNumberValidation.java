package com.vtrack.vtrack.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueMobileNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNumberValidation {
    String message() default "Mobile number already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}