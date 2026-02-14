package com.ewallet.payment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

    private Long customerId;
    private Long merchantId;
    private Double amount;
    private String status;
}
