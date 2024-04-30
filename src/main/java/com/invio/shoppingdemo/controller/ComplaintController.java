package com.invio.shoppingdemo.controller;

import com.invio.shoppingdemo.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ComplaintController {
    @MessageMapping("/complaint")
    @SendTo("/topic/complaints")
    public String handleComplaint(String complaint) throws Exception {
        return "Şikayetiniz alındı. İyi günler dileriz:)";
    }
}

