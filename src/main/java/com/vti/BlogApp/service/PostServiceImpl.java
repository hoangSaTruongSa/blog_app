package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.mapper.PostMapper;
import com.vti.BlogApp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor//Tạo Contructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;


    @Override
    public PostDto createPost(PostCreateForm form) {

        var post = PostMapper.map(form);//ánh xạ từ PostCreateForm sang entity Post
        var savedPost = postRepository.save(post);//Lưu entity Post xuống DataBase

        return PostMapper.map(savedPost);//ánh xạ ngược lại từ DataBase sang Dto trả về cho Client
    }
}
