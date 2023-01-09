package com.example.appapi.service;

import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.MessagePrivate;
import com.example.appapi.model.entity.MessagePublic;
import com.example.appapi.repository.MessagePrivateRepo;
import com.example.appapi.repository.MessagePublicRepo;
import com.example.appapi.repository.ConversationPublicRepo;
import com.example.appapi.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessagePublicRepo messagePublicRepo;
    private final ObjectMapperUtil objectMapperUtil;
    private final ConversationPublicRepo conversationPublicRepo;
    private final MessagePrivateRepo messagePrivateRepo;

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

//    public List<PublicRoomDTO> getAllPublicRoom(){
//        return ConversationPublic.convertToDTOs(publicRoomRepo.findAll(), CommonConst.WITHOUT_RELATION);
//    }

//    public ConversationPublicDTO getPublicRoomById(Long publicRoomId){
//        Optional<ConversationPublic> publicRoom = publicRoomRepo.findById(publicRoomId);
//        if(!publicRoom.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorType.CAN_NOT_FIND_PUBLIC_ROOM);
//        }
//        return publicRoom.get().convertToDTO(CommonConst.WITH_RELATION);
//    }
}
