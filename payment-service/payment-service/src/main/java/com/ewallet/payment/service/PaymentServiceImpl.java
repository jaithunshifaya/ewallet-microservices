package com.ewallet.payment.service;

import com.ewallet.payment.client.MerchantClient;
import com.ewallet.payment.client.NotificationClient;
import com.ewallet.payment.client.WalletClient;
import com.ewallet.payment.dto.NotificationRequest;
import com.ewallet.payment.dto.PaymentRequest;
import com.ewallet.payment.dto.PaymentResponse;
import com.ewallet.payment.entity.TransactionLedger;
import com.ewallet.payment.exception.InsufficientBalanceException;
import com.ewallet.payment.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final TransactionRepository transactionRepository;
    private final WalletClient walletClient;
    private final MerchantClient merchantClient;
    private final NotificationClient notificationClient;

    @Override
    @Transactional
    public PaymentResponse initiatePayment(PaymentRequest request) {

        log.info("Payment started for customer {}", request.getCustomerId());

        Double balance = walletClient.getWalletBalance(request.getCustomerId());

        if (balance < request.getAmount()) {
            throw new InsufficientBalanceException("Insufficient Wallet Balance");
        }

        walletClient.deductAmount(request.getCustomerId(), request.getAmount());

        Double fee = request.getAmount() * 0.02;
        Double merchantCredit = request.getAmount() - fee;

        merchantClient.creditMerchant(request.getMerchantId(), merchantCredit);

        TransactionLedger ledger = TransactionLedger.builder()
                .customerId(request.getCustomerId())
                .merchantId(request.getMerchantId())
                .amount(request.getAmount())
                .walletFee(fee)
                .currency(request.getCurrency())
                .status("SUCCESS")
                .transactionTime(LocalDateTime.now())
                .build();

        TransactionLedger saved = transactionRepository.save(ledger);

        notificationClient.sendNotification(
                NotificationRequest.builder()
                        .customerId(request.getCustomerId())
                        .merchantId(request.getMerchantId())
                        .amount(request.getAmount())
                        .status("SUCCESS")
                        .build()
        );

        return new PaymentResponse(
                "Payment Successful",
                "SUCCESS",
                saved.getTransactionId()
        );

    }
}
