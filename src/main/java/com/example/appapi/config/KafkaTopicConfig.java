package com.example.appapi.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic privateTopicChat(){
        return TopicBuilder.name("privateTopicChat")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic publicTopicChat(){
        return TopicBuilder.name("publicTopicChat")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
