package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.form.PostCreateForm;

public interface PostService {
    PostDto createPost(PostCreateForm form);
}
