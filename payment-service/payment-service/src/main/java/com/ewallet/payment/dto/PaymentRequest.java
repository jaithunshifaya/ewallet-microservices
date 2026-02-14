package com.ewallet.payment.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long customerId;
    private Long merchantId;
    private Double amount;
    private String currency;
}
