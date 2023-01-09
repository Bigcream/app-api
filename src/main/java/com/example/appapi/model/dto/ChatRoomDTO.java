package com.example.appapi.model.dto;

import com.example.appapi.model.entity.User;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ChatRoomDTO {
    private String id;
    private List<String> participants;
}
