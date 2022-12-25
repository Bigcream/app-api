package com.example.appapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message_private")
public class MessagePrivateEntity {

    @Id
    @SequenceGenerator(name = "message_private_id_seq", sequenceName = "message_private_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_private_id_seq")
    protected Long id;

    private String senderName;

    private String receiverName;

    private String message;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "receiver_id")
    private Long receiverId;

    @ManyToOne
    @JoinColumn(name = "sender_id", insertable = false, updatable = false)
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", insertable = false, updatable = false)
    private UserEntity receiver;
}
