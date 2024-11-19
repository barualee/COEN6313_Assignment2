package com.assignment2.orderservice.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment2.orderservice.entities.DeliveryAddress;
import com.assignment2.orderservice.entities.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{state}")
    @ResponseBody
    public List<Order> getOrdersByState(@PathVariable String state){
        return orderService.getOrdersByState(state);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createOrder")
    @ResponseBody
    public Order createOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateOrderStatus")
    @ResponseBody
    public Order updateOrderStatus(@RequestParam int orderId, @RequestParam String status){
        return orderService.updateOrderStatus(orderId, status);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateOrderDeliveryAddress")
    @ResponseBody
    public List<Order> updateOrderDeliveryAddress(@RequestParam int user_id, @RequestBody DeliveryAddress deliveryAddress){
        return orderService.updateOrderDeliveryAddress(user_id, deliveryAddress);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateOrderEmails")
    @ResponseBody
    public List<Order> updateOrderEmails(@RequestParam int user_id, @RequestBody String[] emails){
        return orderService.updateOrderEmails(user_id, emails);
    }
}
