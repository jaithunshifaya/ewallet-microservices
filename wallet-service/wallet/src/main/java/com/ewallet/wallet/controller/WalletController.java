package com.ewallet.wallet.controller;

import com.ewallet.wallet.entity.Wallet;
import com.ewallet.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/create")
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @GetMapping("/balance/{customerId}")
    public Double getBalance(@PathVariable Long customerId) {
        return walletService.getBalance(customerId);
    }

    @PostMapping("/deduct")
    public void deductAmount(@RequestParam Long customerId,
                             @RequestParam Double amount) {
        walletService.deductAmount(customerId, amount);
    }
}
