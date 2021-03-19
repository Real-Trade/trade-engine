package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.models.Order;
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
    public Order createOrder (@RequestBody Order order) {
        //validate object
        //create in db
        log.info(order.toString());
        return order;
    }

    @GetMapping
    public String getAllOrders() {
        return "Orders";
    }

    @GetMapping(path = "{orderId}")
    public String getOrderById(@PathVariable("orderId") Long orderId) {
        return "Order" + orderId;
    }

    @PutMapping(path = "{orderId")
    public String updateOrder(@PathVariable(name = "orderId") Long orderId, @RequestBody String orderUpdate) {
        return "Updated Order : " + orderId + " " + orderUpdate;
    }

    @DeleteMapping
    public boolean deleteOrder(@RequestParam(name = "orderId") String orderId) {
        return true;
    }

}
