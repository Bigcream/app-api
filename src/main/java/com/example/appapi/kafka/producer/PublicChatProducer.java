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
public class PublicChatProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicChatProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToPublicChat(UserEntity data){
        MessageKafka messageKafka = new MessageKafka();
        messageKafka.setData(data);
        messageKafka.setMessage("test");
        Message<MessageKafka> message = MessageBuilder.withPayload(messageKafka)
                .setHeader(KafkaHeaders.TOPIC, "publicTopicChat")
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "key0")
                .build();
        kafkaTemplate.send(message);
    }

    public void saveMessage(MessageKafka messageKafka){

    }
}

