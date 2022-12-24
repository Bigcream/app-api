package com.example.appapi.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
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
    @OrderBy(value = "seq")
    private List<MessageRoomEntity> messageRoom;
}
