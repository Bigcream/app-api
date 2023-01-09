package com.example.appapi.model.dto;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MessagePublicDTO {
    protected String id;
    private String sender;
    private String content;
    private Date time_created;
    private String conversationPublicId;
}
