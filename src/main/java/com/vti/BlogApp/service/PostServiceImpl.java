package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.form.PostCreateForm;
import com.vti.BlogApp.form.PostFilterForm;
import com.vti.BlogApp.form.PostUpdateForm;
import com.vti.BlogApp.mapper.PostMapper;
import com.vti.BlogApp.repository.PostRepository;
import com.vti.BlogApp.specification.PostSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<PostDto> findAllPost(PostFilterForm form, Pageable pageable) {
        var spec = PostSpecification.buildSpec(form);
        return postRepository
                .findAll(spec, pageable)
                .map(PostMapper::map);//lambda, method reference
    }

    @Override
    public PostDto findPostById(Long id) {
       var post = postRepository.findById(id).get();
       return PostMapper.map(post);
    }

    @Override
    public PostDto updatePost(PostUpdateForm form, Long id) {
        var post = PostMapper.map(form);
        post.setId(id);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public boolean existsByTitle(String title) {
        return postRepository.existsByTitle(title);
    }


}
