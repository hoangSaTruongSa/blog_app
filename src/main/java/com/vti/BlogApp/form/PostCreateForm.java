package com.vti.BlogApp.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm
//Class tạo các parameter người dùng nhập vào để tạo Post
{
    @NotBlank(message = "{post.title.NotBlank.message}")
    @Length(max = 50)
    private String title;

    @NotBlank
    @Length(max = 100)
    private String description;

    @NotBlank
    @Length(max = 150)
    private String content;

}
