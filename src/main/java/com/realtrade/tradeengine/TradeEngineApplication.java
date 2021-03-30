package com.realtrade.tradeengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradeEngineApplication {
	private static final Logger log = LoggerFactory.getLogger(TradeEngineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TradeEngineApplication.class, args);
	}

}


