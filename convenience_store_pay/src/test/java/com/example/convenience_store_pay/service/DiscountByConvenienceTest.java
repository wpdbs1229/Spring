package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.dto.PayRequest;
import com.example.convenience_store_pay.type.ConvenienceType;
import com.example.convenience_store_pay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();
    @Test
    void discountTest() {
        //given
        PayRequest payRequestG24 =
                new PayRequest(PayMethodType.MONEY, ConvenienceType.G24, 1000);
        PayRequest payRequestSeeU=
                new PayRequest(PayMethodType.MONEY, ConvenienceType.SeeU, 1000);
        PayRequest payRequestELEVEN =
                new PayRequest(PayMethodType.MONEY, ConvenienceType.ELEVEN, 1000);

        //when
        Integer discountedAmountG24 = discountByConvenience.getDiscountedAmount(payRequestG24);
        Integer discountedAmountSeeU = discountByConvenience.getDiscountedAmount(payRequestSeeU);
        Integer discountedAmountELEVEN = discountByConvenience.getDiscountedAmount(payRequestELEVEN);


        //then
        assertEquals(800, discountedAmountG24);
        assertEquals(900, discountedAmountSeeU);
        assertEquals(1000, discountedAmountELEVEN);
      }
}