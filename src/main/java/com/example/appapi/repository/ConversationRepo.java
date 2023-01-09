package com.example.appapi.repository;

import com.example.appapi.model.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepo extends MongoRepository<Conversation, String> {
}
