package com.example.appapi.repository;

import com.example.appapi.model.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends MongoRepository<Role, String> {
    Role findByName(String role);
}
