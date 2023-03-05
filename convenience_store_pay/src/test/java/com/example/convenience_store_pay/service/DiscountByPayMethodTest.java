package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.dto.PayRequest;
import com.example.convenience_store_pay.type.ConvenienceType;
import com.example.convenience_store_pay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void dicountSuccess() {
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.G24,1000);
        PayRequest payRequestCARD = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G24,1000);
        //when

        Integer discountedAmountMoney =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCARD =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);


        //then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000,discountedAmountCARD);
      }
}