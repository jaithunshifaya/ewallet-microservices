package com.ewallet.payment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_ledger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long customerId;

    private Long merchantId;

    private Double amount;

    private Double walletFee;

    private String currency;

    private String status;

    private LocalDateTime transactionTime;
}
