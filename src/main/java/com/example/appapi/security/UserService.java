package com.example.appapi.security;

import com.example.appapi.model.entity.UserEntity;
import com.example.appapi.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final IUserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = Optional.ofNullable(userRepo.findByUsername(username));
        if(!userEntity.isPresent()){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(userEntity.get());
    }
}
