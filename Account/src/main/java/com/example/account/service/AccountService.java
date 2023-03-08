package com.example.account.service;


import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor // -> final같이 생성자 꼭 필요한 녀석의 생성자 생성 해주는 거얌!! final의 경우 생성자를 통해 값을 넣어줘야하기 때문에
public class AccountService {
    private final AccountRepository accountRepository; // 의존성

    @Transactional
    public void createAccount() {
        Account account = Account.builder()
                        .accountNumber("40000")
                        .accountStatus(AccountStatus.IN_USR)
                        .build();
     accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id){

        if (id < 0){
            throw new RuntimeException("Minus");
        }
        return accountRepository.findById(id).get();
    }
}
