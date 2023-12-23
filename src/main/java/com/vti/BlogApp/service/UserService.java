package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.UserDto;
import com.vti.BlogApp.form.UserCreateForm;

public interface UserService {
    UserDto createUser(UserCreateForm form);
}
