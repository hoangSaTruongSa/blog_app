package com.vti.BlogApp.dto;
import com.vti.BlogApp.entity.Role;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
