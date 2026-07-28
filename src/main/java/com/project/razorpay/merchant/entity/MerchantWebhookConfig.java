package com.project.razorpay.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantWebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "merchant_id",nullable = false)
    private Merchant merchant;

    @Column(nullable = false,length = 200)
    private String targetUrl;

    @Column(length = 200)
    private String webhookSecretHash;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(length = 255)
    private String eventType;//comma-separated list of event types to subscribe to
}
