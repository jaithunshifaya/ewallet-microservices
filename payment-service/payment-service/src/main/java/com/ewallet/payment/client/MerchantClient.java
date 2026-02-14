package com.ewallet.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "merchant-service", url = "http://localhost:8082")
public interface MerchantClient {

    @PostMapping("/merchant/credit")
    void creditMerchant(@RequestParam Long merchantId,
                        @RequestParam Double amount);
}
