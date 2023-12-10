package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> findAllComment(Pageable pageable);
    CommentDto createComment(CommentCreateForm form, Long postId);
}
