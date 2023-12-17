package com.vti.BlogApp.controller;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import com.vti.BlogApp.form.CommentFilterForm;
import com.vti.BlogApp.form.CommentUpdateForm;
import com.vti.BlogApp.service.CommentService;
import com.vti.BlogApp.validation.CommentIdExists;
import com.vti.BlogApp.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/v1/comments")
    @ResponseStatus(HttpStatus.OK)
    public Page<CommentDto> findAllComment(CommentFilterForm form, Pageable pageable)
    {
        return commentService.findAllComment(form, pageable);
    }

    @GetMapping("/api/v1/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto findCommentById(@PathVariable("commentId") @CommentIdExists Long commentId)
    {
        return commentService.findCommentById(commentId);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDto> findCommentByPostId(@PathVariable("postId") @PostIdExists Long postId, Pageable pageable)
    {
        return commentService.findCommentByPostId(postId, pageable);
    }

    @PostMapping("/api/v1/post/{postId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto createComment(@RequestBody @Valid CommentCreateForm form,
                                    @PathVariable("postId") Long postId)
    {
        return commentService.createComment(form, postId);
    }

    @PutMapping("/api/v1/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto updateComment(@RequestBody @Valid CommentUpdateForm form,
                                    @PathVariable("commentId") @CommentIdExists Long commentId)
    {
        return commentService.updateComment(form, commentId);
    }

    @DeleteMapping("/api/v1/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentById(@PathVariable("commentId") @CommentIdExists Long id)
    {
        commentService.deleteCommentById(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentByEmail(@PathVariable("email") String email)
    {
        commentService.deleteCommentByEmail(email);
    }

}
