package org.amjad.notificationservice;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message) {
        // Logique pour envoyer une notification
        System.out.println("Sending notification: " + message);

        // Exemple : envoyer un email ou un SMS
        // Vous pouvez intégrer ici un service tiers comme Twilio, SendGrid, etc.
    }
}