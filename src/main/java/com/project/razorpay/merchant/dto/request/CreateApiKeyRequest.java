package com.project.razorpay.merchant.dto.request;

import com.project.razorpay.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
