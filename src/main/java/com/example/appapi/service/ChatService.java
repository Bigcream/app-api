package com.example.appapi.service;

import com.example.appapi.constant.ConstCommon;
import com.example.appapi.constant.ErrorType;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.dto.PublicRoomDTO;
import com.example.appapi.model.entity.MessagePrivate;
import com.example.appapi.model.entity.MessageRoom;
import com.example.appapi.model.entity.PublicRoom;
import com.example.appapi.repository.MessagePrivateRepo;
import com.example.appapi.repository.MessageRoomRepo;
import com.example.appapi.repository.PublicRoomRepo;
import com.example.appapi.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessageRoomRepo messageRoomRepo;
    private final ObjectMapperUtil objectMapperUtil;
    private final PublicRoomRepo publicRoomRepo;
    private final MessagePrivateRepo messagePrivateRepo;

    @Transactional
    public void saveMessagePublicChat(MessageKafka messageKafka){
        MessageRoom messageRoom = objectMapperUtil.convertObject(MessageRoom.class, messageKafka);
        messageRoomRepo.save(messageRoom);
    }
    @Transactional
    public void saveMessagePrivateChat(MessageKafka messageKafka){
        MessagePrivate messageRoom = objectMapperUtil.convertObject(MessagePrivate.class, messageKafka);
        messagePrivateRepo.save(messageRoom);
    }

    public List<PublicRoomDTO> getAllPublicRoom(){
        return PublicRoom.convertToDTOs(publicRoomRepo.findAll(), ConstCommon.WITHOUT_RELATION);
    }

    public PublicRoomDTO getPublicRoomById(Long publicRoomId){
        Optional<PublicRoom> publicRoom = publicRoomRepo.findById(publicRoomId);
        if(!publicRoom.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorType.CAN_NOT_FIND_PUBLIC_ROOM);
        }
        return publicRoom.get().convertToDTO(ConstCommon.WITH_RELATION);
    }
}
