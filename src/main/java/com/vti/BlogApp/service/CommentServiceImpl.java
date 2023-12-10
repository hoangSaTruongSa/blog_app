package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import com.vti.BlogApp.form.CommentUpdateForm;
import com.vti.BlogApp.mapper.CommentMapper;
import com.vti.BlogApp.repository.CommentRepository;
import com.vti.BlogApp.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Page<CommentDto> findAllComment(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(CommentMapper::map);
    }

    @Override
    public CommentDto createComment(CommentCreateForm form, Long postId) {
        var comment = CommentMapper.map(form);
        var post = postRepository.findById(postId).get();
        comment.setPost(post);
        var commentSaved = commentRepository.save(comment);
        return CommentMapper.map(commentSaved);
    }

    @Override
    public CommentDto updateComment(CommentUpdateForm form, Long commentId) {
        var comment = commentRepository.findById(commentId).get();
        CommentMapper.map(form, comment);
        var commentSaved = commentRepository.save(comment);
        return CommentMapper.map(commentSaved);
    }
}
