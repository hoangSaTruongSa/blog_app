package com.vti.BlogApp.validation;

import com.vti.BlogApp.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostIdExistsValidator implements ConstraintValidator<PostIdExists, Long> {
    private  final PostRepository postRepository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return postRepository.existsById(id);
    }
}
