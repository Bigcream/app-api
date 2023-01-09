package com.example.appapi.model.entity;

import com.example.appapi.model.dto.MessagePublicDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "message_public")
public class MessagePublic {
    @Id
    protected String id;

    private String sender;

    private String content;

    @CreatedDate
    private Date time_created;

    private String conversationPublicId;

    public MessagePublicDTO convertToDTO(){
        return MessagePublicDTO.builder()
                .id(this.getId())
                .time_created(this.getTime_created())
                .sender(this.getSender())
                .content(this.getContent())
                .conversationPublicId(this.getConversationPublicId())
                .build();
    }

    public static List<MessagePublicDTO> convertToDTOs(List<MessagePublic> messagePublics){
        List<MessagePublicDTO> messagePublicDTOS;
        messagePublicDTOS = messagePublics.stream().map(MessagePublic::convertToDTO).collect(Collectors.toList());
        return messagePublicDTOS;
    }

}