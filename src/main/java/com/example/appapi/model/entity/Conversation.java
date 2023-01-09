package com.example.appapi.model.entity;


import com.example.appapi.model.dto.ChatRoomDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.List;

@Document(collection = "conversation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conversation {
    @Id
    private String id;
    private List<String> participants;

    public ChatRoomDTO convertToDTO(){
        return ChatRoomDTO.builder()
                .id(this.getId())
                .participants(this.getParticipants())
                .build();
    }
}
