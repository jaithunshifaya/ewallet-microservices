package com.ewallet.payment.repository;

import com.ewallet.payment.entity.TransactionLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionLedger, Long> {
}
