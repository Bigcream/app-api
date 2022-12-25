package com.example.appapi.controller;

import com.example.appapi.model.dto.PublicRoomDTO;
import com.example.appapi.model.entity.Gallery;
import com.example.appapi.model.entity.UserEntity;
import com.example.appapi.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HomeController extends BaseController {
    private final ChatService chatService;
    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports. // We load balance among them, and display which instance received the request.  return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
        return "Gallery Service";
    }

    @GetMapping("/get-public-rooms")
    public ResponseEntity<List<PublicRoomDTO>> sendMessageToPrivateChat(){
        return new  ResponseEntity<>(chatService.getAllPublicRoom(), noCacheHeader, HttpStatus.OK);
    }

    @GetMapping("/get-public-room/{publicRoomId}")
    public ResponseEntity<PublicRoomDTO> sendMessageToPrivateChat(@PathVariable Long publicRoomId){
        return new  ResponseEntity<>(chatService.getPublicRoomById(publicRoomId), noCacheHeader, HttpStatus.OK);
    }
}
