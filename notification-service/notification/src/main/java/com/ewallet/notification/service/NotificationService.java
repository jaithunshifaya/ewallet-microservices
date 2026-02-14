package com.ewallet.notification.service;

import com.ewallet.notification.dto.NotificationRequest;

public interface NotificationService {
    void sendNotification(NotificationRequest request);
}
