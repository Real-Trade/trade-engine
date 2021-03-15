package com.realtrade.tradeengine.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/soapWS/*");
    }

    @Bean(name = "trades")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema tradeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TradeServicePort");
        wsdl11Definition.setLocationUri("/soapWS");
        wsdl11Definition.setTargetNamespace("http://realtrade/tradeengine");
        wsdl11Definition.setSchema(tradeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema tradeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("trades.xsd"));
    }
}

