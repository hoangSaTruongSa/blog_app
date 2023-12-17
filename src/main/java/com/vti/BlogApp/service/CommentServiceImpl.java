package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.form.CommentCreateForm;
import com.vti.BlogApp.form.CommentFilterForm;
import com.vti.BlogApp.form.CommentUpdateForm;
import com.vti.BlogApp.mapper.CommentMapper;
import com.vti.BlogApp.repository.CommentRepository;
import com.vti.BlogApp.repository.PostRepository;
import com.vti.BlogApp.specification.CommentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Page<CommentDto> findAllComment(CommentFilterForm form, Pageable pageable) {
        var spec = CommentSpecification.buildSpec(form);
        return commentRepository.findAll(spec, pageable)
                .map(CommentMapper::map);
    }

    @Override
    public CommentDto findCommentById(Long commentId) {
        var comment = commentRepository.findById(commentId).get();
        return CommentMapper.map(comment);
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
    @Transactional
    public CommentDto updateComment(CommentUpdateForm form, Long commentId) {
        var comment = commentRepository.findById(commentId).get();
        CommentMapper.map(form, comment);
        var commentSaved = commentRepository.save(comment);
        return CommentMapper.map(commentSaved);
    }

    @Override
    @Transactional
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCommentByEmail(String email) {
        commentRepository.deleteCommentByEmail(email);
    }

    @Override
    public Page<CommentDto> findCommentByPostId(Long postId, Pageable pageable) {
        return commentRepository.findCommentByPostId(postId, pageable)
                .map(CommentMapper::map);
    }
}
