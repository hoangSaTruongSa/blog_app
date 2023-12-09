package com.vti.BlogApp.mapper;

import com.vti.BlogApp.dto.CommentDto;
import com.vti.BlogApp.entity.Comment;
import com.vti.BlogApp.form.CommentCreateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form)
    {
        var comment = new Comment();

        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }

    public static CommentDto map(Comment comment)
    {
        var commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        commentDto.setCreatedAt(comment.getCreatedAt());
        commentDto.setUpdatedAt(comment.getUpdatedAt());
        return commentDto;
    }
}
