package com.example.appapi.model.dto;

import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RoleDTO {
    private int id;
    private String name;
    private Set<UserDTO> users;
}
