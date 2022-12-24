package com.example.appapi.repository;

import com.example.appapi.model.entity.MessageRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRoomRepo extends JpaRepository<MessageRoomEntity, Long> {
}
