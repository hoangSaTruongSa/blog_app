package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.entity.Post;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.mapper.PostMapper;
import com.vti.BlogApp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


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

    @Override
    public Page<PostDto> findAllPost(Pageable pageable) {
        return postRepository
                .findAll(pageable)
                .map(PostMapper::map);//lambda, method reference
    }



}
