//package com.example.appapi.security;
//
//import com.example.appapi.model.entity.User;
//import com.example.appapi.repository.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserRepo userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userEntity = Optional.ofNullable(userRepo.findByUsername(username));
//        if(!userEntity.isPresent()){
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomUserDetails(userEntity.get());
//    }
//}
