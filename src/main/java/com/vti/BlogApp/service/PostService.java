package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto createPost(PostCreateForm form);
    Page<PostDto> findAllPost(Pageable pageable);
    PostDto findPostById(Long id);
    PostDto updatePost(PostUpdateForm form, Long id);
    void deletePostById(Long id);
}
