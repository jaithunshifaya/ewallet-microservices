package com.ewallet.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {

    private String message;
    private String status;
    private Long transactionId;
}
