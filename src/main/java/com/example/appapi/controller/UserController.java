package com.example.appapi.controller;

import com.example.appapi.model.entity.User;
import com.example.appapi.security.CustomUserDetails;
import com.example.appapi.security.jwt.JwtTokenProvider;
import com.example.appapi.service.UserChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserChatService userChatService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        // Set info authentication to Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //responsive jwt for user
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new  ResponseEntity<>(jwt, noCacheHeader, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new  ResponseEntity<>(userChatService.register(user), noCacheHeader, HttpStatus.OK);
    }

}
