# Spring
Spring 공부 repository!

## 삽질
순수 자바프로젝트로 삽질해보기! Spring을 만들어보자!

----
### 순서
1. 순수 자바로 된 프로젝트 생성
2. 직접 심플 스프링 만들기
3. 스프링을 활용해 순수 자바 프로젝트 동작해보기

### 프로젝트 설명
- 편의점 결제 서비스
  - 편의점 간편결제 시스템
  - 사용자 - 편의점 결제 서비스(구현할 서비스) - 결제수단 시스템(제작되어진 시스템이용)

### 프로젝트 환경
- InteliJ
- JAVA 11
- Gradle
- Spring Boot 2.7.9

### 요구사항
- G24, SeeU, 11
- 머니 결제기능 추가
- 카드 결제기능 추가
- 할인 기능 추가
  - 편의점 브랜드 별
  - 카드, 머니 등 결제방식 할인 기능

### 클래스
- 결제 서비스
  - 결제
  - 결제 취소
- 머니 어댑터
  - 머니 사용
  - 머니 사용 취소 

### 중요 포인트
- (결제 방식) PayMentInterface를 구현하여, MoneyAdapter, CardAdapter가 interface에 의존하도록 설정 (DIP)
  - 따라서, 다른 결제방식이나와도 큰 무리없이 추가 가능
- (할인 방식) DiscountInterface를 구현하여, 이 또한 편의점, 결제수단 등의 할인 방식이 interface에 의존하도록 설정
- Appconfig를 만들어 아예 ConveniencePayService에서 각 구현체를 의존하지 않도록 Appconfig에서 의존하도록 바꿈
