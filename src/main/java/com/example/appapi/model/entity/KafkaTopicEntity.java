package com.example.appapi.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "kafka topic")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaTopicEntity {
    @Id
    @SequenceGenerator(name = "kafka topic_id_seq", sequenceName = "kafka topic_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kafka topic_id_seq")
    protected Long id;

    private String topicName;
}
