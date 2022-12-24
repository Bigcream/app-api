package com.example.appapi.kafka.producer;
import com.example.appapi.constant.ErrorType;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.MessageRoomEntity;
import com.example.appapi.model.entity.PublicRoomEntity;
import com.example.appapi.repository.IMessageRoomRepo;
import com.example.appapi.repository.IPublicRoomRepo;
import com.example.appapi.util.CommonUtil;
import com.example.appapi.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublicChatProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublicChatProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final IMessageRoomRepo messageRoomRepo;
    private final CommonUtil commonUtil;
    private final ObjectMapperUtil objectMapperUtil;
    private final IPublicRoomRepo publicRoomRepo;

    public void sendMessageToPublicChat(MessageKafka messageKafka){
//        messageKafka.setTime(commonUtil.getTimeNow());
        MessageRoomEntity messageRoom = objectMapperUtil.convertObject(MessageRoomEntity.class, messageKafka);
//        Optional<PublicRoomEntity> publicRoom = publicRoomRepo.findById(messageKafka.getRoom_public_id());
//        if (!publicRoom.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorType.CAN_NOT_FIND_PUBLIC_ROOM);
//        }
//        messageRoom.setPublicRoom(publicRoom.get());
        messageRoomRepo.save(messageRoom);
        Message<MessageKafka> message = MessageBuilder.withPayload(messageKafka)
                .setHeader(KafkaHeaders.TOPIC, "publicTopicChat")
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "key0")
                .build();
        kafkaTemplate.send(message);
    }
}

