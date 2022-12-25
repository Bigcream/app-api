package com.example.appapi.service;

import com.example.appapi.constant.ConstCommon;
import com.example.appapi.constant.ErrorType;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.dto.PublicRoomDTO;
import com.example.appapi.model.entity.MessagePrivateEntity;
import com.example.appapi.model.entity.MessageRoomEntity;
import com.example.appapi.model.entity.PublicRoomEntity;
import com.example.appapi.repository.IMessagePrivateRepo;
import com.example.appapi.repository.IMessageRoomRepo;
import com.example.appapi.repository.IPublicRoomRepo;
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
    private final IMessageRoomRepo messageRoomRepo;
    private final ObjectMapperUtil objectMapperUtil;
    private final IPublicRoomRepo publicRoomRepo;
    private final IMessagePrivateRepo messagePrivateRepo;

    @Transactional
    public void saveMessagePublicChat(MessageKafka messageKafka){
        MessageRoomEntity messageRoom = objectMapperUtil.convertObject(MessageRoomEntity.class, messageKafka);
        messageRoomRepo.save(messageRoom);
    }
    @Transactional
    public void saveMessagePrivateChat(MessageKafka messageKafka){
        MessagePrivateEntity messageRoom = objectMapperUtil.convertObject(MessagePrivateEntity.class, messageKafka);
        messagePrivateRepo.save(messageRoom);
    }

    public List<PublicRoomDTO> getAllPublicRoom(){
        return PublicRoomEntity.convertToDTOs(publicRoomRepo.findAll(), ConstCommon.WITHOUT_RELATION);
    }

    public PublicRoomDTO getPublicRoomById(Long publicRoomId){
        Optional<PublicRoomEntity> publicRoom = publicRoomRepo.findById(publicRoomId);
        if(!publicRoom.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorType.CAN_NOT_FIND_PUBLIC_ROOM);
        }
        return publicRoom.get().convertToDTO(ConstCommon.WITH_RELATION);
    }
}
