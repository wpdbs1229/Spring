package com.example.convenience_store_pay;

import com.example.convenience_store_pay.config.ApplicationConfig;
import com.example.convenience_store_pay.dto.PayCancelRequest;
import com.example.convenience_store_pay.dto.PayCancelResponse;
import com.example.convenience_store_pay.dto.PayRequest;
import com.example.convenience_store_pay.dto.PayResponse;
import com.example.convenience_store_pay.service.ConveniencePayService;
import com.example.convenience_store_pay.type.ConvenienceType;
import com.example.convenience_store_pay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 결제 -> 머니
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService",
                        ConveniencePayService.class);

        //G24, 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.G24, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse.toString());


        //취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.CARD,
                ConvenienceType.G24, 500);
        PayCancelResponse payCancelResponse =
                conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse.toString());
    }
}
