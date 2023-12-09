package com.vti.BlogApp.controller;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import com.vti.BlogApp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/v1/post/{postId}/comments")
    public CommentDto createComment(@RequestBody CommentCreateForm form,
                                    @PathVariable("postId") Long postId)
    {
        return commentService.createComment(form, postId);
    }
}
