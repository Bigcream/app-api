package com.example.appapi.model.entity;

import com.example.appapi.model.dto.MessageRoomDTO;
import com.example.appapi.util.CommonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "message_room")
public class MessageRoom {
    @Id
    @SequenceGenerator(name = "message_room_id_seq", sequenceName = "message_room_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_room_id_seq")
    protected Long id;

    private String senderName;

    private String message;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(name = "public_room_id")
    private Long publicRoomId;

    @Column(name = "user_id")
    private Long userId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "public_room_id", insertable = false, updatable = false)
    private PublicRoom publicRoom;

    public MessageRoomDTO convertToDTO(){
        return MessageRoomDTO.builder()
                .id(this.getId())
                .public_room_id(this.getPublicRoomId())
                .time(CommonUtil.formatTime(this.getTime()))
                .senderName(this.getSenderName())
                .message(this.getMessage())
                .userId(this.getUserId())
                .build();
    }

    public static List<MessageRoomDTO> convertToDTOs(List<MessageRoom> messageRooms){
        List<MessageRoomDTO> messageRoomDTOS;
        messageRoomDTOS = messageRooms.stream().map(MessageRoom::convertToDTO).collect(Collectors.toList());
        return messageRoomDTOS;
    }

}