package com.example.appapi.repository;

import com.example.appapi.model.entity.PublicRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicRoomRepo extends JpaRepository<PublicRoom, Long> {
}
