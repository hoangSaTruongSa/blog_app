package com.vti.BlogApp.validation;

import com.vti.BlogApp.repository.CommentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdExistsValidator implements ConstraintValidator<CommentIdExists, Long>{
    private final CommentRepository commentRepository;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return commentRepository.existsById(id);
    }
}
