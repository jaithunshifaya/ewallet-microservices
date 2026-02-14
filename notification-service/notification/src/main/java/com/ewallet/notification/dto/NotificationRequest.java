package com.ewallet.notification.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    private Long customerId;
    private Long merchantId;
    private Double amount;
    private String status;
}
