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
public class PrivateChatProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrivateChatProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ChatService chatService;
    public void sendMessageToPrivateChat(MessageKafka messageKafka){
        chatService.saveMessagePrivateChat(messageKafka);
        Message<MessageKafka> message = MessageBuilder.withPayload(messageKafka)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopic.PRIVATE_CHAT_TOPIC)
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "key0")
                .build();
        kafkaTemplate.send(message);
    }
}
