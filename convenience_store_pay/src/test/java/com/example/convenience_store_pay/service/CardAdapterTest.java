package com.example.convenience_store_pay.service;

import com.example.convenience_store_pay.type.CardUseCancelResult;
import com.example.convenience_store_pay.type.CardUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {

    private CardAdapter cardAdapter = new CardAdapter();

    @Test
    void capture_success () {
        //given
       Integer payAmount = 99;

        //when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);


        //then
        assertEquals(CardUseResult.USE_SUCCESS,cardUseResult);
      }

    void capture_fail () {
        //given
        Integer payAmount = 101;

        //when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);


        //then
        assertEquals(CardUseResult.USE_FAIL,cardUseResult);
    }

    @Test
    void cancelCapture_success() {
        //given
        Integer cancelAmount = 1001;


        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

        //then
        assertEquals(CardUseCancelResult.USE_CANCEL_SUCCESS,cardUseCancelResult);
    }

    @Test
    void cancelCapture_fail() {
        //given
        Integer cancelAmount = 999;


        //when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

        //then
        assertEquals(CardUseCancelResult.USE_CANCEL_FAIL,cardUseCancelResult);
    }
}