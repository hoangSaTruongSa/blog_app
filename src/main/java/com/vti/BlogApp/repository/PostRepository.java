package com.vti.BlogApp.repository;

import com.vti.BlogApp.dto.PostDto;
import com.vti.BlogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post,Long>,
        JpaSpecificationExecutor<Post>
//Kế thừa Lớp của JPA đã có sẵn CRUD chỉ việc lấy để dùng <Entity,Kiểu dữ liệu khóa chính>
{
    boolean existsByTitle(String title);
}
