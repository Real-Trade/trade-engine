package com.realtrade.tradeengine;

import com.realtrade.tradeengine.endpoint.OrderClient;
import com.realtrade.tradeengine.wsdl.GetOrderResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TradeEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeEngineApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(OrderClient client) {
		return args -> {
			String orderId = "3L";
			if(args.length > 0) {
				orderId = args[0];
			}
			GetOrderResponse response = client.getOrder(orderId);
			System.err.println("Order volume: " + response.getOrder().getVolume());
		};
	}

}
