package com.ewallet.merchant.controller;

import com.ewallet.merchant.entity.Merchant;
import com.ewallet.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/create")
    public Merchant createMerchant(@RequestBody Merchant merchant) {
        return merchantService.createMerchant(merchant);
    }

    @PostMapping("/credit")
    public void creditMerchant(@RequestParam Long merchantId,
                               @RequestParam Double amount) {
        merchantService.creditMerchant(merchantId, amount);
    }
}
