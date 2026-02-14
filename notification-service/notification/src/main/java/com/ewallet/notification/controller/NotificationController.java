package com.ewallet.notification.controller;

import com.ewallet.notification.dto.NotificationRequest;
import com.ewallet.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/payment")
    public ResponseEntity<String> notifyPayment(
            @RequestBody NotificationRequest request) {

        service.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
