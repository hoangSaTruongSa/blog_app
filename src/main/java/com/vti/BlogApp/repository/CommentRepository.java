package com.vti.BlogApp.repository;

import com.vti.BlogApp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findCommentByPostId(Long postId, Pageable pageable);
}
