package com.example.appapi.model.dto;

import com.example.appapi.model.entity.User;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ChatRoomDTO {
    private Long chatRoomId;
    private User createBy;
    private Set<User> userInRooms;
}
