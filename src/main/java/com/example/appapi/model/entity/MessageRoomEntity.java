package com.example.appapi.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "message_room")
public class MessageRoomEntity {
    @Id
    @SequenceGenerator(name = "message_room_id_seq", sequenceName = "message_room_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_room_id_seq")
    protected Long id;
    private Long seq;
    private String senderName;
    private String message;

    @ManyToOne
    @JoinColumn(name = "room_public_id")
    private PublicRoomEntity publicRoom;

}
