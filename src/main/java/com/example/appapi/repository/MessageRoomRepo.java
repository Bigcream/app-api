package com.example.appapi.repository;

import com.example.appapi.model.entity.MessageRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRoomRepo extends JpaRepository<MessageRoom, Long> {
}
