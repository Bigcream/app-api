package com.example.appapi.model.entity;

import com.example.appapi.model.dto.ConversationPublicDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "conversation_public")
public class ConversationPublic {
    @Id
    protected String id;
    private String name;

    public ConversationPublicDTO convertToDTO(){
        return ConversationPublicDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
