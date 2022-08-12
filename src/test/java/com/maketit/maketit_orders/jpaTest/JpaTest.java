package com.maketit.maketit_orders.jpaTest;


import com.maketit.maketit_orders.MarketitOrdersApplication;
import com.maketit.maketit_orders.account.domain.Account;
import com.maketit.maketit_orders.account.repository.AccountRepository;
import com.maketit.maketit_orders.product.domain.Product;
import com.maketit.maketit_orders.product.repository.ProductRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MarketitOrdersApplication.class)
@Transactional
public class JpaTest {
    @Autowired private AccountRepository accountRepository;
    @Autowired private ProductRepository productRepository;


    @Test
    @Commit
    void addAccount() {
        Account account = Account.builder()
                .email("jhlee@naver.com")
                .password("1234!") // 암호화 스킵
                .name("jeonghun")
                .address("서울특별시 성동구 성수동")
                .phone("010-4312-4112")
                .build();
        Account account2 = Account.builder()
                .email("minsu@naver.com")
                .password("1234!") // 암호화 스킵
                .name("minsu")
                .address("서울특별시 중랑구 중화동")
                .phone("010-1234-4321")
                .build();
        accountRepository.save(account);
        accountRepository.save(account2);
    }

    @Test
    @Commit
    void addProduct() {
        Product product = Product.builder()
                .name("닭가슴살")
                .price(9900L)
                .stock(10L)
                .build();
        Product product2 = Product.builder()
                .name("햇반")
                .price(24900L)
                .stock(4L)
                .build();
        Product product3 = Product.builder()
                .name("키보드")
                .price(124900L)
                .stock(12L)
                .build();
        Product product4 = Product.builder()
                .name("마우스")
                .price(34900L)
                .stock(2L)
                .build();
        Product product5 = Product.builder()
                .name("모니터")
                .price(324900L)
                .stock(9L)
                .build();
        Product product6 = Product.builder()
                .name("휴대폰 케이스")
                .price(10900L)
                .stock(20L)
                .build();
        Product product7 = Product.builder()
                .name("헤드셋")
                .price(40900L)
                .stock(10L)
                .build();
        Product product8 = Product.builder()
                .name("USB 허브")
                .price(324900L)
                .stock(5L)
                .build();
        Product product9 = Product.builder()
                .name("비타민 영양제")
                .price(42900L)
                .stock(10L)
                .build();
        Product product10 = Product.builder()
                .name("아이폰 13")
                .price(1224900L)
                .stock(5L)
                .build();
        Product product11 = Product.builder()
                .name("아이폰 12")
                .price(1124900L)
                .stock(0L)
                .build();
        productRepository.save(product);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
        productRepository.save(product11);
    }
}
