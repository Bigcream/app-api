package com.example.appapi.service;

import com.example.appapi.constant.KafkaServiceApi;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.util.KafkaServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaServiceUtil kafkaServiceUtil;

    public void sendMessagePublic(MessageKafka messageKafka) {
        kafkaServiceUtil.sendMessage(messageKafka, KafkaServiceApi.SEND_PUBLIC_CHAT);
    }

    public void sendMessagePrivate(MessageKafka messageKafka) {
        kafkaServiceUtil.sendMessage(messageKafka, KafkaServiceApi.SEND_PRIVATE_CHAT);
    }
}
