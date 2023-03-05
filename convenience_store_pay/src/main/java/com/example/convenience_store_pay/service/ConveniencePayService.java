package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.dto.*;
import com.example.convenience_store_pay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService {

    private final Map<PayMethodType,PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;


    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountInterface) {

       paymentInterfaceSet.forEach(
               paymentInterface -> paymentInterfaceMap.put(
                       paymentInterface.getPayMethodType(),
                       paymentInterface
               )
       );

        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);

        //fail fast

        //Method()

        //Exception case1
        //Exception case2

        if (payment == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

        //Success Case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);


    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPaymentResult =
                paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());


        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL,0);
        }

        //Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS
                , payCancelRequest.getPayCancelAmount());
    }
}
