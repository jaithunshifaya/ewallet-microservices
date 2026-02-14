package com.ewallet.payment.service;

import com.ewallet.payment.dto.PaymentRequest;
import com.ewallet.payment.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse initiatePayment(PaymentRequest request);
}
