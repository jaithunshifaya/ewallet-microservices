package com.ewallet.merchant.service;

import com.ewallet.merchant.entity.Merchant;
import com.ewallet.merchant.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public Merchant createMerchant(Merchant merchant) {
        merchant.setCreatedAt(LocalDateTime.now());
        return merchantRepository.save(merchant);
    }

    @Transactional
    public void creditMerchant(Long merchantId, Double amount) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        merchant.setBalance(merchant.getBalance() + amount);
        merchantRepository.save(merchant);
    }
}
