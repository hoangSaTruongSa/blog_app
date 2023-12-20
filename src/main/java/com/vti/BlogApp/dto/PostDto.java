package com.vti.BlogApp.dto;
import com.vti.BlogApp.controller.PostController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class PostDto extends RepresentationModel<PostDto>
//Class Hiển thị kết quả cho người dùng
{
    private Long id;
    private String title;
    private String description;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostDto withSelfRel()
    {
        var controller = methodOn(PostController.class);
        var dto = controller.findPostById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
