package com.example.appapi.kafka.producer;

import com.example.appapi.constant.KafkaTopic;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.service.ChatService;
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
public class PublicChatProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublicChatProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ChatService chatService;

    public void sendMessageToPublicChat(MessageKafka messageKafka){
        chatService.saveMessagePublicChat(messageKafka);
        Message<MessageKafka> message = MessageBuilder.withPayload(messageKafka)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopic.PUBLIC_CHAT_TOPIC)
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "key0")
                .build();
        kafkaTemplate.send(message);
    }
}

