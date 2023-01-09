package com.example.appapi.repository;

import com.example.appapi.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
