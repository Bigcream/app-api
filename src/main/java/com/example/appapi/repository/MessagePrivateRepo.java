package com.example.appapi.repository;

import com.example.appapi.model.entity.MessagePrivate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagePrivateRepo extends MongoRepository<MessagePrivate, String> {
}
