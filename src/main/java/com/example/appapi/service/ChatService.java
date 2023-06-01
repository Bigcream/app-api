package com.example.appapi.service;

import com.example.appapi.kafka.producer.ChatPublicProducer;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.Conversation;
import com.example.appapi.model.entity.MessagePrivate;
import com.example.appapi.model.entity.MessagePublic;
import com.example.appapi.repository.ConversationRepo;
import com.example.appapi.repository.MessagePrivateRepo;
import com.example.appapi.repository.MessagePublicRepo;
import com.example.appapi.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessagePublicRepo messagePublicRepo;
    private final ObjectMapperUtil objectMapperUtil;
    private final MessagePrivateRepo messagePrivateRepo;
    private final ConversationRepo conversationRepo;
    private final ChatPublicProducer chatPublicProducer;
//    private final ChatPrivateProducer chatPrivateProducer;

    @Transactional
    public void saveMessagePublicChat(MessageKafka messageKafka){
        MessagePublic messagePublic = objectMapperUtil.convertObject(MessagePublic.class, messageKafka);
        messagePublicRepo.save(messagePublic);
    }
    @Transactional
    public void saveMessagePrivateChat(MessageKafka messageKafka){
        MessagePrivate messageRoom = objectMapperUtil.convertObject(MessagePrivate.class, messageKafka);
        messagePrivateRepo.save(messageRoom);
    }

    @Transactional
    public MessagePublic sendMessagePublic(MessageKafka messageKafka, String conversationPublicId) {
        MessagePublic messagePublic = MessagePublic.builder()
                .sender(messageKafka.getSender())
                .content(messageKafka.getContent())
                .conversationPublicId(conversationPublicId)
                .build();
        messagePublic = messagePublicRepo.save(messagePublic);
        messageKafka.setConversationId(conversationPublicId);
        try {
            chatPublicProducer.sendMessageToPublicChat(messageKafka);
        } catch (Exception e){
            throw new RuntimeException("Can't send message public to kafka");
        }
        return messagePublic;
    }

//    @Transactional
//    public MessagePrivate sendMessagePrivate(MessageKafka messageKafka, Optional<String> optConversationId) {
//        String conversationId;
//        if(!optConversationId.isPresent()) {
//            List<String> participants = new ArrayList<>();
//            participants.add(messageKafka.getSender());
//            participants.add(messageKafka.getReceiver());
//            Conversation conversation = Conversation.builder()
//                    .participants(participants)
//                    .build();
//            conversation = conversationRepo.save(conversation);
//            conversationId = conversation.getId();
//        } else {
//            conversationId = optConversationId.get();
//        }
//        MessagePrivate messagePrivate = MessagePrivate.builder()
//                .sender(messageKafka.getSender())
//                .content(messageKafka.getContent())
//                .conversationId(conversationId)
//                .build();
//        messagePrivate = messagePrivateRepo.save(messagePrivate);
//        messageKafka.setConversationId(conversationId);
//        try {
//            chatPrivateProducer.sendMessageToPrivateChat(messageKafka);
//        } catch (Exception e){
//            throw new RuntimeException("Can't send message private to kafka");
//        }
//        return messagePrivate;
//    }

}
