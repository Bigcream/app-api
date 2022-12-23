package com.example.appapi.service;

import com.example.appapi.model.entity.UserEntity;
import com.example.appapi.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserChatService {
    private final IUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserEntity register(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
