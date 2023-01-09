package com.example.appapi.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "message_private")
public class MessagePrivate {

    @Id
    protected String id;
    
    private String sender;

    private String content;

    @CreatedDate
    private Date time_created;

    private String conversationId;
}
