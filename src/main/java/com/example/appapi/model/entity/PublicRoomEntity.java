package com.example.appapi.model.entity;

import com.example.appapi.model.dto.PublicRoomDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "public_room")
public class PublicRoomEntity {
    @Id
    @SequenceGenerator(name = "public_room_id_seq", sequenceName = "public_room_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public_room_id_seq")
    protected Long id;
    private String roomName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publicRoom")
    @OrderBy(value = "time ASC")
    private List<MessageRoomEntity> messageRoom;

    public PublicRoomDTO convertToDTO(boolean withRelation){
        PublicRoomDTO publicRoomDTO = PublicRoomDTO.builder()
                .id(this.getId())
                .roomName(this.getRoomName())
                .build();
        if(withRelation){
            publicRoomDTO.setMessageRoom(MessageRoomEntity.convertToDTOs(this.getMessageRoom()));
        }
        return publicRoomDTO;
    }

    public static List<PublicRoomDTO> convertToDTOs(List<PublicRoomEntity> publicRoomEntities, boolean withRelation){
        List<PublicRoomDTO> publicRoomDTOS = new ArrayList<>();
        publicRoomEntities.forEach(publicRoom -> publicRoomDTOS.add(publicRoom.convertToDTO(withRelation)));
        return publicRoomDTOS;
    }
}
