package com.stocks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.stocks.*")
@ComponentScan(basePackages = { "com.stocks.*" })
@EntityScan("com.stocks.*")   
public class StockAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockAnalysisApplication.class, args);
	}

}
