package com.example.account.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    @Enumerated(EnumType.STRING) // 실제 문자열이 저장됨,
    private AccountStatus accountStatus;

}
