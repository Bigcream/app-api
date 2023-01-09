package com.example.appapi.model.dto;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ConversationPublicDTO {
    private String id;
    private String name;
}
