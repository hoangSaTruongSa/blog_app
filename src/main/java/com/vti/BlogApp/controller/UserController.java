package com.vti.BlogApp.controller;

import com.vti.BlogApp.dto.UserDto;
import com.vti.BlogApp.form.UserCreateForm;
import com.vti.BlogApp.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public UserDto createUser(@RequestBody @Valid UserCreateForm form)
    {
        return userService.createUser(form);
    }
}
