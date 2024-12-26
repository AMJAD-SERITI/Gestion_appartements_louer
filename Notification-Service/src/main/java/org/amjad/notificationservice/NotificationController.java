package org.amjad.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Endpoint pour tester l'envoi d'une notification
    @PostMapping("/send")
    public String sendNotification(@RequestParam String message) {
        notificationService.sendNotification(message);
        return "Notification sent: " + message;
    }

    // Endpoint pour vérifier si le service fonctionne
    @GetMapping("/health")
    public String healthCheck() {
        return "Notification Service is running!";
    }
}