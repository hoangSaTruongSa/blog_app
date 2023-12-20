package com.vti.BlogApp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Constraint(
        validatedBy = PostTitleNotExistsValidator.class
)
@Target(FIELD)
@Retention(RUNTIME)

public @interface PostTitleNotExists {
    String message() default "{post.title.NotExists.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
