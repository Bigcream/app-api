package com.example.appapi.model.dto;

import lombok.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private List<MessageRoomDTO> messageRooms;
    private Set<RoleDTO> roles;
}
