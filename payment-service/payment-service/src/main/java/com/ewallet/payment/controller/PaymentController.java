package com.ewallet.payment.controller;

import com.ewallet.payment.dto.PaymentRequest;
import com.ewallet.payment.dto.PaymentResponse;
import com.ewallet.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public PaymentResponse initiatePayment(@RequestBody PaymentRequest request) {
        return paymentService.initiatePayment(request);
    }
}
