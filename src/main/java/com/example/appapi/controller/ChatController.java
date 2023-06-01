package com.example.appapi.controller;


import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.MessagePrivate;
import com.example.appapi.model.entity.MessagePublic;
import com.example.appapi.service.ChatService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatController extends BaseController {

    private final ChatService chatService;
    @PostMapping("/chat-public")
    public ResponseEntity<MessagePublic> sendMessageToPublicChat(@RequestBody MessageKafka messageKafka,
                                                                 @RequestParam String conversationPublicId){
        return new  ResponseEntity<>(chatService.sendMessagePublic(messageKafka, conversationPublicId), noCacheHeader, HttpStatus.OK);
    }

//    @PostMapping("/chat-private")
//    public ResponseEntity<MessagePrivate> sendMessageToPrivateChat(@RequestBody MessageKafka messageKafka,
//                                                                   @RequestParam(required = false) Optional<String> conversationId){
//        return new  ResponseEntity<>(chatService.sendMessagePrivate(messageKafka, conversationId), noCacheHeader, HttpStatus.OK);
//    }
//    private final ChatRoomService chatRoomService;
//    private final UserChatService userChatService;
//
//    @MessageMapping("/message")
//    public Message receiveMessage(@Payload Message message) throws Exception {
//        userChatService.sendPublicChat(message);
//        return message;
//    }
//
//    @MessageMapping("/join-room")
//    public Message userJoinRoom(@Payload Message message) throws Exception {
//        userChatService.joinRoom(message);
//        return message;
//    }
//    @MessageMapping("/create-room")
//    public String userCreateRoom(@Payload Message message) throws Exception {
//        return chatRoomService.createRoom(message);
//    }
//
//    @MessageMapping("/private-message")
//    public Message recMessage(@Payload Message message) throws Exception {
//        userChatService.sendPrivateChat(message);
//        return message;
//    }
//    @GetMapping("/room-available")
//    public List<ChatRoomDTO> getAllRoomAvailable(){
//        return UtilityActor.askObject(actorCommon, new ChatRoom.GetAllRoomAvailable(), ChatRoomDTO.class);
//    }
//    @GetMapping("/leave-room/{roomId}")
//    public ResponseEntity<Void> leaveRoom(@PathVariable Long roomId, @RequestParam String username){
//        return new  ResponseEntity<>(chatRoomService.leaveRoom(roomId, username), noCacheHeader, HttpStatus.OK);
//    }
//    @GetMapping("/all-user-online")
//    public List<String> getAllUserOnline(){
//        return UtilityActor.askObject(actorCommon, new ChatRoom.GetAllUserOnline(), String.class);
//    }
}
