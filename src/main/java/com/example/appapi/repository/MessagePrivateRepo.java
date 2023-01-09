package com.example.appapi.repository;

import com.example.appapi.model.entity.MessagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagePrivateRepo extends JpaRepository<MessagePrivate, Long> {
}
