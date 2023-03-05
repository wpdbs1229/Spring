package com.example.convenience_store_pay.dto;

import com.example.convenience_store_pay.type.ConvenienceType;
import com.example.convenience_store_pay.type.PayMethodType;

public class PayRequest {

    // 편의점 종륲
    ConvenienceType convenienceType;

    PayMethodType payMethodType;
    // 결제 금액
    Integer payAmount;

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    public PayRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
