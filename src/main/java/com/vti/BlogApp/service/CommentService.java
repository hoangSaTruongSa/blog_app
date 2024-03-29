package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import com.vti.BlogApp.form.CommentFilterForm;
import com.vti.BlogApp.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> findAllComment(CommentFilterForm form, Pageable pageable);
    CommentDto findCommentById(Long commentId);
    Page<CommentDto> findCommentByPostId(Long postId, Pageable pageable);
    CommentDto createComment(CommentCreateForm form, Long postId);
    CommentDto updateComment(CommentUpdateForm form, Long commentId);
    void deleteCommentById(Long id);
    void deleteCommentByEmail(String email);

}
