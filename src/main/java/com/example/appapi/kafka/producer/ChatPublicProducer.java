package com.example.appapi.kafka.producer;


import com.example.appapi.constant.KafkaTopic;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.util.SerializerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.appapi.constant.KafkaTopic.PUBLIC_CHAT_TOPIC;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatPublicProducer {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final static long sendTimeout = 3000;

    public void sendMessageToPublicChat(MessageKafka messageKafka) {
        byte[] eventsBytes = SerializerUtils.serializeToJsonBytes(messageKafka);
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(PUBLIC_CHAT_TOPIC, eventsBytes);

        try {
            kafkaTemplate.send(record).get(sendTimeout, TimeUnit.MILLISECONDS);
            log.info("publishing kafka record value >>>>> {}", new String(record.value()));

        } catch (Exception ex) {
            log.error("(KafkaEventBus) publish get timeout", ex);
            throw new RuntimeException(ex);
        }
    }
}

