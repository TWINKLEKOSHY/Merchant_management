package com.example.merchant_management.Controller;

import com.example.merchant_management.Service.MerchantService;
import com.example.merchant_management.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public Merchant addMerchant(@RequestBody Merchant merchant) {
        return merchantService.addMerchant(merchant);
    }

    @GetMapping
    public List<Merchant> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

    @GetMapping("/{id}")
    public Merchant getMerchantById(@PathVariable Long id) {

        return merchantService.getMerchantById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMerchant(@PathVariable Long id) {
        merchantService.deleteMerchant(id);
    }
}
