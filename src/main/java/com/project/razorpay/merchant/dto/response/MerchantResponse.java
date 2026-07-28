package com.project.razorpay.merchant.dto.response;

import com.project.razorpay.enums.BusinessType;
import com.project.razorpay.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus

) {
}
