package com.example.appapi.controller;


import com.example.appapi.kafka.producer.PrivateChatProducer;
import com.example.appapi.kafka.producer.PublicChatProducer;
import com.example.appapi.model.dto.MessageKafka;
import com.example.appapi.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatController extends BaseController {
    private final PublicChatProducer publicChatProducer;
    private final PrivateChatProducer privateChatProducer;
    @PostMapping("/public-chat")
    public ResponseEntity<String> sendMessageToPublicChat(@RequestBody MessageKafka messageKafka){
        publicChatProducer.sendMessageToPublicChat(messageKafka);
        return ResponseEntity.ok("Message sent to public chat");
    }

    @PostMapping("/private-chat")
    public ResponseEntity<String> sendMessageToPrivateChat(@RequestBody MessageKafka messageKafka){
        privateChatProducer.sendMessageToPrivateChat(messageKafka);
        return ResponseEntity.ok("Message sent to private chat");
    }
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
