package com.example.appapi.model.entity;


import com.example.appapi.model.dto.ChatRoomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "chat_room")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "chat_room_id", unique = true)
    private Long chatRoomId;

//    @ManyToOne
//    @JoinColumn(name = "created_by")
//    @CreatedBy
//    private User createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;


    public ChatRoomDTO convertToDTO(){
        return ChatRoomDTO.builder()
                .chatRoomId(this.getChatRoomId())
                .build();
    }
}