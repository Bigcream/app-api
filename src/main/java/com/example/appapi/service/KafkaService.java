package com.example.appapi.service;

import com.example.appapi.constant.KafkaServiceApi;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.Conversation;
import com.example.appapi.model.entity.MessagePrivate;
import com.example.appapi.model.entity.MessagePublic;
import com.example.appapi.repository.ConversationRepo;
import com.example.appapi.repository.MessagePrivateRepo;
import com.example.appapi.repository.MessagePublicRepo;
import com.example.appapi.util.CommonUtil;
import com.example.appapi.util.KafkaServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaServiceUtil kafkaServiceUtil;
    private final MessagePrivateRepo messagePrivateRepo;
    private final MessagePublicRepo messagePublicRepo;
    private final ConversationRepo conversationRepo;

    @Transactional
    public MessagePublic sendMessagePublic(MessageKafka messageKafka, String conversationPublicId) {
        MessagePublic messagePublic = MessagePublic.builder()
                .sender(messageKafka.getSender())
                .content(messageKafka.getContent())
                .conversationPublicId(conversationPublicId)
                .build();
        messagePublic = messagePublicRepo.save(messagePublic);
        kafkaServiceUtil.sendMessage(messageKafka, KafkaServiceApi.SEND_PUBLIC_CHAT);
        return messagePublic;
    }

    @Transactional
    public MessagePrivate sendMessagePrivate(MessageKafka messageKafka, Optional<String> optConversationId) {
        String conversationId;
        if(!optConversationId.isPresent()) {
            List<String> participants = new ArrayList<>();
            participants.add(messageKafka.getSender());
            participants.add(messageKafka.getReceiver());
            Conversation conversation = Conversation.builder()
                    .participants(participants)
                    .build();
            conversation = conversationRepo.save(conversation);
            conversationId = conversation.getId();
//            messageKafka.setConversationId(conversationId);
//            kafkaServiceUtil.sendMessage(messageKafka, KafkaServiceApi.CREATE_CONVERSATION);
        } else {
            conversationId = optConversationId.get();
        }
        MessagePrivate messagePrivate = MessagePrivate.builder()
                .sender(messageKafka.getSender())
                .content(messageKafka.getContent())
                .conversationId(conversationId)
                .build();
        messagePrivate = messagePrivateRepo.save(messagePrivate);
        messageKafka.setConversationId(conversationId);
        kafkaServiceUtil.sendMessage(messageKafka, KafkaServiceApi.SEND_PRIVATE_CHAT);
        return messagePrivate;
    }


}
