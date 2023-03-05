package com.example.convenience_store_pay.dto;

import com.example.convenience_store_pay.service.PaymentInterface;
import com.example.convenience_store_pay.type.ConvenienceType;
import com.example.convenience_store_pay.type.PayMethodType;

public class PayCancelRequest {
    PayMethodType payMethodType;

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    //편의점 종류
    ConvenienceType convenienceType;
    Integer payCancelAmount;

    public PayCancelRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payCancelAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    // 취소 금액

}
