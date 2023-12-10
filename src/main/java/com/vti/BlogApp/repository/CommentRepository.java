package com.vti.BlogApp.repository;

import com.vti.BlogApp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {
   /* //Method Name
    Page<Comment> findCommentByPostId(Long postId, Pageable pageable);*/

    //@Query annotation
    @Query("FROM Comment WHERE post.id =:postId")
    Page<Comment> findCommentByPostId(@Param("postId") Long postId, Pageable pageable);

    @Query("DELETE Comment WHERE email =:email")
    @Modifying
    void deleteCommentByEmail(@Param("email") String email);
}
