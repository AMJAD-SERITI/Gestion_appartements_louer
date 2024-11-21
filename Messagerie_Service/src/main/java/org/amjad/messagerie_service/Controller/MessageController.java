package org.amjad.messagerie_service.Controller;


import org.amjad.messagerie_service.Entities.Message;
import org.amjad.messagerie_service.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/{senderId}/{receiverId}")
    public List<Message> getMessages(
            @PathVariable Long senderId,
            @PathVariable Long receiverId) {
        return messageService.getMessages(senderId, receiverId);
    }

    @GetMapping("/receiver/{receiverId}")
    public List<Message> getMessagesForReceiver(@PathVariable Long receiverId) {
        return messageService.getMessagesForReceiver(receiverId);
    }
}
