package com.example.appapi.repository;

import com.example.appapi.model.entity.ConversationPublic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationPublicRepo extends MongoRepository<ConversationPublic, String> {
}
