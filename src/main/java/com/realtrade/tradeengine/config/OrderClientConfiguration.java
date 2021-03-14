package com.realtrade.tradeengine.config;

import com.realtrade.tradeengine.service.OrderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrderClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.realtrade.tradeengine.wsdl");
        return marshaller;
    }

    @Bean
    public OrderClient orderClient(Jaxb2Marshaller marshaller) {
        OrderClient client = new OrderClient();
        client.setDefaultUri("https://soap-producer-demo.herokuapp.com/soapWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
