package com.vti.BlogApp.service;

import com.vti.BlogApp.dto.UserDto;
import com.vti.BlogApp.entity.Role;
import com.vti.BlogApp.form.UserCreateForm;
import com.vti.BlogApp.mapper.UserMapper;
import com.vti.BlogApp.repository.RoleRepository;
import com.vti.BlogApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService,
        UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    public UserDto createUser(UserCreateForm form) {
        var user = UserMapper.map(form);
        var encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        var role = roleRepository.findByType(Role.Type.USER);
        user.setRoles(Set.of(role));
        var userSaved = userRepository.save(user);
        return UserMapper.map(userSaved);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException(username);
        }
        var authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            var authority = new SimpleGrantedAuthority(role.getType().toString());
            authorities.add(authority);
        }
        return new User(user.getUsername(),
                user.getPassword(),
                authorities);
    }
}
