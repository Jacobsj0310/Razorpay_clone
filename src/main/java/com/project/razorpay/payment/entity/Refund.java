package com.project.razorpay.payment.entity;

import com.project.razorpay.entity.Money;
import com.project.razorpay.enums.RefundStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

@Entity
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "payment_id",nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    private RefundStatus status = RefundStatus.PENDING;

    @Column(length = 200)
    private String bankReference;

    @Column(length = 200)
    private String errorCode;

    @Column(length = 500)
    private  String errorDescription;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String,Object>notes;

    private LocalDateTime processedAt;
}
