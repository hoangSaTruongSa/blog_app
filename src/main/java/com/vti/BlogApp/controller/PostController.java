package com.vti.BlogApp.controller;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.form.PostFilterForm;
import com.vti.BlogApp.form.PostUpdateForm;
import com.vti.BlogApp.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAllPost(PostFilterForm form ,Pageable pageable)
    {
        return postService.findAllPost(form, pageable);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostDto findPostById(@PathVariable("id") Long id)
    {
        return postService.findPostById(id);
    }

    @PostMapping("/api/v1/posts")
    public PostDto createPost(@RequestBody @Valid PostCreateForm form)
    {
        return postService.createPost(form);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostDto updatePost( @RequestBody PostUpdateForm form,
                               @PathVariable("id") Long id)
    {
        return postService.updatePost(form, id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deletePostById(@PathVariable("id") Long id)
    {
        postService.deletePostById(id);
    }
}
