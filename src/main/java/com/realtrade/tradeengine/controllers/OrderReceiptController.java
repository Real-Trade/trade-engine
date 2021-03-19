package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.dto.OrderDto;
import com.realtrade.tradeengine.services.OrderService;
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
    private final OrderService orderService;

    @Autowired
    public OrderReceiptController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto submitOrder (@RequestBody OrderDto orderDto) {
        //validate object
        //create in db
        log.info(orderDto.toString());
        return orderDto;
    }

    @GetMapping
    public String getAllOrders() {
        return "Orders";
    }

    @GetMapping(path = "{orderId}")
    public String getOrderById(@PathVariable("orderId") int orderId) {
        return "Order" + orderId;
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
