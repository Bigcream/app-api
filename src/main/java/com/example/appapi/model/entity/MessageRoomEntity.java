package com.example.appapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "message_room")
public class MessageRoomEntity {
    @Id
    @SequenceGenerator(name = "message_room_id_seq", sequenceName = "message_room_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_room_id_seq")
    protected Long id;
    private Long seq;
    private String senderName;
    private String message;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    private Long public_room_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "public_room_id", insertable = false, updatable = false)
    private PublicRoomEntity publicRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
