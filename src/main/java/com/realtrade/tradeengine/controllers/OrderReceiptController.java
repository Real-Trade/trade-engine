package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.dto.OrderDto;
import com.realtrade.tradeengine.services.TradeExecutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
@CrossOrigin
public class OrderReceiptController {

    private  static final Logger log = LoggerFactory.getLogger(OrderReceiptController.class);
    private TradeExecutionService executionService;

    @Autowired
    public OrderReceiptController(TradeExecutionService executionService) {
        this.executionService = executionService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto submitOrder (@RequestBody OrderDto orderDto) {

        log.info(orderDto.toString());
        executionService.handleClientOrder(orderDto.getLocalRepresentation());
        return orderDto;
    }


    @PutMapping(path = "/{orderId/update")
    public String updateOrder(@PathVariable(name = "orderId") int orderId, @RequestBody OrderDto orderUpdate) {
        return "Updated Order : " + orderId + " " + orderUpdate.toString();
    }

    @DeleteMapping(path = "/{orderId}/cancel")
    public boolean cancelOrder(@PathVariable(name = "orderId") int orderId) {
        return true;
    }

}
