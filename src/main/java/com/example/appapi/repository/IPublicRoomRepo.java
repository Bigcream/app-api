package com.example.appapi.repository;

import com.example.appapi.model.entity.PublicRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicRoomRepo extends JpaRepository<PublicRoomEntity, Long> {
}
