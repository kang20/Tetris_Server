package com.example.tetris_server.Controller;

import com.example.tetris_server.Data.DTO.MultiMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MultiMessage sendMessage(@Payload MultiMessage chatMessage) {


        return chatMessage;
    }
}
