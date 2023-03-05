package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
