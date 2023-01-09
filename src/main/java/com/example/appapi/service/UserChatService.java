package com.example.appapi.service;

import com.example.appapi.constant.RoleConstant;
import com.example.appapi.model.entity.Role;
import com.example.appapi.model.entity.User;
import com.example.appapi.repository.RoleRepo;
import com.example.appapi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserChatService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    public User register(User user) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepo.findByName(RoleConstant.ROLE_ADMIN);
        roles.add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        return userRepo.save(user);
    }
}
