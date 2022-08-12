package com.maketit.maketit_orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MarketitOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketitOrdersApplication.class, args);
	}

}
