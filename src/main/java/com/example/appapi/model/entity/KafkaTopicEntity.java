package com.example.appapi.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "kafka_topic")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaTopicEntity {
    @Id
    @SequenceGenerator(name = "kafka_topic_id_seq", sequenceName = "kafka_topic_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kafka_topic_id_seq")
    protected Long id;

    private String topicName;
}
