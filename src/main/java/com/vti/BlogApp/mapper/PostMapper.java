package com.vti.BlogApp.mapper;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.entity.Post;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.form.PostUpdateForm;

public class PostMapper {
    public static Post map(PostCreateForm form)
    {
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setDescription(form.getDescription());
        post.setContent(form.getContent());

        return post;
    }

    public static Post map(PostUpdateForm form)
    {
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setDescription(form.getDescription());
        post.setContent(form.getContent());

        return post;
    }

    public static PostDto map(Post post)
    {
        var postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());

        return postDto.withSelfRel();
    }
}
