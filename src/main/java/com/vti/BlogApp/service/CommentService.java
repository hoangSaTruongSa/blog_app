package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;

public interface CommentService {
    CommentDto createComment(CommentCreateForm form, Long postId);
}
