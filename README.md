
# Market It 주문관리 APi 명세서

## Tech Stack
- Java 8 / Spring Boot v2.7.2
- Gradle
- Postgresql (DB)

## Dependencies
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Boot DevTools
- Lombok
- Postgresql Driver

## ERD
![erd](https://user-images.githubusercontent.com/34118304/184312979-b4aaefc5-e725-4fc0-95fa-2d4cb35236f5.PNG)

![api](https://user-images.githubusercontent.com/34118304/184314181-6a5e7b1b-8325-4039-92ba-81f4150e2422.PNG)

## Validation
- 재고
  - 상품의 잔여 재고보다 많은 수량 주문시 Result Error 

## Business Logic

- 주문처리
  - Product Id를 통해 상품 존재유무 판단, 주문수량보다 상품 재고가 적을 경우 주문 실패
  - email로 유저 존재 판단
  - 주문수량 * 상품 가격으로 해당 주문건의 총 주문금액 계산
  - 주문대기 상태로 주문처리
  - 해당 주문상품의 재고 변경

- 주문완료
  - 정상적인 결제 또는 주문완료 로직이 수행되었다고 가정하에 해당 주문건의 주문상태를 주문완료 상태로 변경
  - 해당 주문건의 주문상태가 주문완료, 주문취소일 경우 Error return
 
- 주문조회(단건)
  - 해당 주문건의 주문내역을 보여줌
  
- 주문조회(전체)
  - 해당 유저의 전체 주문내역을 보여줌
  
  
## Postman Detail
- 주문처리
 
![accept](https://user-images.githubusercontent.com/34118304/184318346-af48ed72-2a6b-48e0-8d94-0ac43b2cc6ec.PNG)
![accept2](https://user-images.githubusercontent.com/34118304/184318352-00c934e1-5458-4c77-8b0b-a875c1186a38.PNG)

- 주문완료

![complete](https://user-images.githubusercontent.com/34118304/184318353-52ce7fdf-655d-4ff6-8e4e-bca688950221.PNG)
![complete2](https://user-images.githubusercontent.com/34118304/184318355-8be7e5d2-5185-4356-8faa-aead93eadf61.PNG)
