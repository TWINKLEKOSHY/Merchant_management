package com.example.merchant_management.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String shopName;
    private String phoneNumber;
    private String ownerName;
    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @ManyToOne
    private Category category;
}


