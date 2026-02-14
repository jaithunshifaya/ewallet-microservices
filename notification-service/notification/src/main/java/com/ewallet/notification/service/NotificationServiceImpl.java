package com.ewallet.notification.service;

import com.ewallet.notification.dto.NotificationRequest;
import com.ewallet.notification.entity.NotificationLog;
import com.ewallet.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    public void sendNotification(NotificationRequest request) {

        logger.info("Sending notification for payment...");

        NotificationLog log = NotificationLog.builder()
                .customerId(request.getCustomerId())
                .merchantId(request.getMerchantId())
                .amount(request.getAmount())
                .status(request.getStatus())
                .message("Payment " + request.getStatus() + " for amount " + request.getAmount())
                .timestamp(LocalDateTime.now())
                .build();

        repository.save(log);

        logger.info("Notification saved successfully");
    }
}
