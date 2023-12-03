package com.vti.BlogApp.repository;

import com.vti.BlogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
