/*
package com.example.tetris_server.Controller;

import com.example.tetris_server.Data.DTO.Greeting;
import com.example.tetris_server.Data.DTO.HelloMessage;
import org.jetbrains.annotations.Debug;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SoketController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println(message.getName() + "  "  + message.getAge());
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }



}
*/
