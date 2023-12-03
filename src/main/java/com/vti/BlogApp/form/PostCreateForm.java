package com.vti.BlogApp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateForm
//Class tạo các parameter người dùng nhập vào để tạo Post
{
    private String title;
    private String description;
    private String content;

}
