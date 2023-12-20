package com.vti.BlogApp.dto;

import com.vti.BlogApp.controller.CommentController;
import com.vti.BlogApp.entity.Post;
import com.vti.BlogApp.repository.CommentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;


import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CommentDto extends RepresentationModel<CommentDto> {
    private Long id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String titlePost;

    public CommentDto withSelfRel()
    {
        var controller = methodOn(CommentController.class);
        var dto = controller.findCommentById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
