package com.ewallet.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "wallet-service", url = "http://localhost:8081")
public interface WalletClient {

    @GetMapping("/wallet/balance/{customerId}")
    Double getWalletBalance(@PathVariable Long customerId);

    @PostMapping("/wallet/deduct")
    void deductAmount(@RequestParam Long customerId,
                      @RequestParam Double amount);
}
