package org.amjad.messagerie_service.Service;


import org.amjad.messagerie_service.Entities.Message;
import org.amjad.messagerie_service.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }

    public List<Message> getMessagesForReceiver(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }
}

