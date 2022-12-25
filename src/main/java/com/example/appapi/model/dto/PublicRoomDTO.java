package com.example.appapi.model.dto;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PublicRoomDTO {
    private Long id;
    private String roomName;
    private List<MessageRoomDTO> messageRoom;
}
