package com.example.merchant_management.Repository;

import com.example.merchant_management.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    boolean findByRegistrationNumber(String registrationNumber);
}
