package com.example.appapi.repository;

import com.example.appapi.model.entity.MessagePublic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagePublicRepo extends MongoRepository<MessagePublic, Long> {
}
