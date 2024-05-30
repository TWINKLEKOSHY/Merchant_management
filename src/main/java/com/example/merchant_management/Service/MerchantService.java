package com.example.merchant_management.Service;
import com.example.merchant_management.Repository.MerchantRepository;
import com.example.merchant_management.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public Merchant addMerchant(Merchant merchant) {
        if (merchantRepository.findByRegistrationNumber(merchant.getRegistrationNumber())) {
            throw new IllegalArgumentException("Merchant with this registration number already exists");
        }
        return merchantRepository.save(merchant);
    }

    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    public Merchant getMerchantById(Long id) {
        return merchantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));
    }

    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }
}
