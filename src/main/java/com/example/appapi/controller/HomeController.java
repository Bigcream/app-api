package com.example.appapi.controller;

import com.example.appapi.model.dto.ConversationPublicDTO;
import com.example.appapi.model.entity.Role;
import com.example.appapi.repository.RoleRepo;
import com.example.appapi.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HomeController extends BaseController {
    private final ChatService chatService;
    private final RoleRepo roleRepo;
    @PostMapping("/role")
    public String home(@RequestBody Role role) {
        roleRepo.save(role);
        return "Gallery Service";
    }

//    @GetMapping("/get-public-rooms")
//    public ResponseEntity<List<ConversationPublicDTO>> sendMessageToPrivateChat(){
//        return new  ResponseEntity<>(chatService.getAllPublicRoom(), noCacheHeader, HttpStatus.OK);
//    }

//    @GetMapping("/get-public-room/{publicRoomId}")
//    public ResponseEntity<ConversationPublicDTO> sendMessageToPrivateChat(@PathVariable Long publicRoomId){
//        return new  ResponseEntity<>(chatService.getPublicRoomById(publicRoomId), noCacheHeader, HttpStatus.OK);
//    }
}
