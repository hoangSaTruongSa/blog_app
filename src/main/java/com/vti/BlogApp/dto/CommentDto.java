package com.vti.BlogApp.dto;

import com.vti.BlogApp.entity.Post;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String titlePost;
}
