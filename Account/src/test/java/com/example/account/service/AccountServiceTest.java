package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock // 가짜로 만든 Repository
    private AccountRepository accountRepository;
    @InjectMocks// 가짜로 만든 REpository를 inject해줌
    private AccountService accountService;

    @Test
    @DisplayName("계좌 조회 성공")
    void testXXX() {
        //given
        given(accountRepository.findById(anyLong()))
                .willReturn(Optional.of(Account.builder()
                        .accountStatus(AccountStatus.UNREGISTERD)
                        .accountNumber("65789")
                        .build()));

        // Long 타입 Captor (박스 만듬)
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        //when
        Account account = accountService.getAccount(4555L);


        //then
        /*
        * times에 따라 accountRepository의 호출횟수가 달라짐
        * 즉, 조회할때는 Repository를 불어와야 하기 때문에 1번
        * 저장할 때는 필요가 없기에 0번호출*/
        verify(accountRepository, times(1)).findById(captor.capture());
      /*  verify(accountRepository, times(0)).save(any());*/
        assertEquals(4555L,captor.getValue());
        assertNotEquals(4551L,captor.getValue());
        assertTrue(4555L == captor.getValue());
        assertEquals("65789", account.getAccountNumber());
        assertEquals(AccountStatus.UNREGISTERD, account.getAccountStatus());
    }


    @Test
    @DisplayName("계좌 조회 실패")
    void testFailedToSearchAccount() {

    /*
    * 이러한 동작이 나올때 RuntimeException이 발생한다~~*/
        //when
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> accountService.getAccount(-10L));
        //then
        assertEquals("Minus", exception.getMessage());

    }
    @BeforeEach
    void init() {
        accountService.createAccount();
    }

    @Test
    void testGetAccount1() {
        Account account = accountService.getAccount(1L);
        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USR, account.getAccountStatus());
    }

    @Test
    @DisplayName("Test 이름 변경~!")
    void testGetAccount2() {
        Account account = accountService.getAccount(2L);
        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USR, account.getAccountStatus());
    }
}