package com.example.appapi.kafka.producer;


import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.util.SerializerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.example.appapi.constant.KafkaTopic.PRIVATE_CHAT_TOPIC;
import static com.example.appapi.constant.KafkaTopic.PUBLIC_CHAT_TOPIC;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatPublicProducer {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final static long sendTimeout = 3000;

    @NewSpan
    public void publicChat(@SpanTag("event") MessageKafka messageKafka) {
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

