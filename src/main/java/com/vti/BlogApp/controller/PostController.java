package com.vti.BlogApp.controller;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public PostDto createPost(@RequestBody PostCreateForm form)
    {
        return postService.createPost(form);
    }
}
