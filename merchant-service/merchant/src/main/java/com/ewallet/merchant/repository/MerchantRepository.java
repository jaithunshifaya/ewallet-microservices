package com.ewallet.merchant.repository;

import com.ewallet.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
