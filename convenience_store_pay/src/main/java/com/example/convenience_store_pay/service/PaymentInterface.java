package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.type.CancelPaymentResult;
import com.example.convenience_store_pay.type.PayMethodType;
import com.example.convenience_store_pay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount );
}
