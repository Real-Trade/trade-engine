package com.realtrade.tradeengine.endpoint;

import com.realtrade.tradeengine.wsdl.GetOrderRequest;
import com.realtrade.tradeengine.wsdl.GetOrderResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class OrderClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(OrderClient.class);

    public GetOrderResponse getOrder(String orderId) {
        GetOrderRequest request = new GetOrderRequest();
        request.setOrderId(orderId);
        log.info("Requesting order: " + orderId);
        GetOrderResponse response = (GetOrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://soap-producer-demo.herokuapp.com/soapWS/",
                        request,
                        new SoapActionCallback(
                                "http://spring/soap-producer-demo/getOrderRequest"));
        return response;
    }
}
