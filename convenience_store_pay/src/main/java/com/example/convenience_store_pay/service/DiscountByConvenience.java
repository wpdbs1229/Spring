package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.dto.PayRequest;

public class DiscountByConvenience implements  DiscountInterface{

    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getConvenienceType()){

            case G24:
                return payRequest.getPayAmount() * 8/ 10;
            case SeeU:
                return payRequest.getPayAmount() * 9/ 10;
            case ELEVEN:
                return payRequest.getPayAmount();
        }
        return payRequest.getPayAmount();
    }
}
