package com.example.appapi.controller;

import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.ConversationPublic;
import com.example.appapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdminController extends BaseController {
    private final AdminService adminService;
    @PostMapping("/create-conversation-public")
    public ResponseEntity<ConversationPublic> createConversationPublic(@RequestBody ConversationPublic conversationPublic){
        return new  ResponseEntity<>(adminService.createConversationPublic(conversationPublic), noCacheHeader, HttpStatus.OK);
    }
}
