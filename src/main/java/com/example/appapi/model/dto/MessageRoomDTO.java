package com.example.appapi.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MessageRoomDTO {
    protected Long id;
    private String senderName;
    private String message;
    private String time;
    private Long public_room_id;
    private Long userId;
    private PublicRoomDTO publicRoom;
    private UserDTO user;
}
