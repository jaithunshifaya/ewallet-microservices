package com.ewallet.wallet.service;

import com.ewallet.wallet.entity.Wallet;
import com.ewallet.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        wallet.setCreatedAt(LocalDateTime.now());
        return walletRepository.save(wallet);
    }

    public Double getBalance(Long customerId) {
        Wallet wallet = walletRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return wallet.getBalance();
    }

    @Transactional
    public void deductAmount(Long customerId, Double amount) {
        Wallet wallet = walletRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (wallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);
    }
}
