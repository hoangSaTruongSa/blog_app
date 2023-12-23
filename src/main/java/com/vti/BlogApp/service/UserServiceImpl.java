package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.UserDto;
import com.vti.BlogApp.form.UserCreateForm;
import com.vti.BlogApp.mapper.UserMapper;
import com.vti.BlogApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserDto createUser(UserCreateForm form) {
        var user = UserMapper.map(form);
        var userSaved = userRepository.save(user);
        return UserMapper.map(userSaved);
    }
}
