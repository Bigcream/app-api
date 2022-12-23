package com.example.appapi.kafka.producer;

import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrivateChatProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrivateChatProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToPrivateChat(UserEntity data){
        MessageKafka messageKafka = MessageKafka.builder().data(data).message("private chat").build();
        Message<MessageKafka> message = MessageBuilder.withPayload(messageKafka)
                .setHeader(KafkaHeaders.TOPIC, "privateTopicChat")
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "key0")
                .build();
        kafkaTemplate.send(message);
    }
}
