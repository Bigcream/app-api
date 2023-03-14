package com.example.appapi.kafka.producer;

import com.example.appapi.constant.KafkaTopic;
import com.kafkaservice.payload.MessageKafka;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConversationProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void createConversation(MessageKafka messageKafka){
        Message<MessageKafka> message = MessageBuilder.withPayload(messageKafka)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopic.CREATE_CONVERSATION)
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "key0")
                .build();
        kafkaTemplate.send(message);
    }
}
