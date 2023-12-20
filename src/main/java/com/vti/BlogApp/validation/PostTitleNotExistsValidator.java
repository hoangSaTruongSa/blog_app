package com.vti.BlogApp.validation;

import com.vti.BlogApp.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostTitleNotExistsValidator implements ConstraintValidator<PostTitleNotExists, String> {
    private  final PostRepository postRepository;
    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        return !postRepository.existsByTitle(title);
    }
}
