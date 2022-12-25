package com.example.appapi.repository;

import com.example.appapi.model.entity.MessagePrivateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessagePrivateRepo extends JpaRepository<MessagePrivateEntity, Long> {
}
