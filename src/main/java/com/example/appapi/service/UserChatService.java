package com.example.appapi.service;

import com.example.appapi.model.entity.User;
import com.example.appapi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserChatService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
