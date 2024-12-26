package org.amjad.notificationservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "reservation-topic", groupId = "notification-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
        // Logique pour gérer le message et envoyer des notifications

        // Exemples de notifications:
        sendNotification(message);
    }

    private void sendNotification(String message) {
        // Logique pour envoyer des notifications (email, SMS, etc.)
        System.out.println("Sending notification for: " + message);
    }
}