package com.vti.BlogApp.repository;

import com.vti.BlogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>
//Kế thừa Lớp của JPA đã có sẵn CRUD chỉ việc lấy để dùng <Entity,Kiểu dữ liệu khóa chính>
{
}
