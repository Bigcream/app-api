package com.example.appapi.service;

import com.example.appapi.model.entity.ConversationPublic;
import com.example.appapi.repository.ConversationPublicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final ConversationPublicRepo conversationPublicRepo;
    public ConversationPublic createConversationPublic(ConversationPublic conversationPublic){
        return conversationPublicRepo.save(ConversationPublic.builder().name(conversationPublic.getName()).build());
    }
}
