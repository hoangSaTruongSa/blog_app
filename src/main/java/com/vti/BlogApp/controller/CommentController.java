package com.vti.BlogApp.controller;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import com.vti.BlogApp.form.CommentUpdateForm;
import com.vti.BlogApp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAllComment(Pageable pageable)
    {
        return commentService.findAllComment(pageable);
    }

    @PostMapping("/api/v1/post/{postId}/comments")
    public CommentDto createComment(@RequestBody CommentCreateForm form,
                                    @PathVariable("postId") Long postId)
    {
        return commentService.createComment(form, postId);
    }

    @PutMapping("/api/v1/comments/{commentId}")
    public CommentDto updateComment(@RequestBody CommentUpdateForm form,
                                    @PathVariable("commentId") Long commentId)
    {
        return commentService.updateComment(form, commentId);
    }
}
