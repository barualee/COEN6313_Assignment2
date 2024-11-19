package com.assignment2.orderservice.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.assignment2.orderservice.entities.AddressChangeMsg;
import com.assignment2.orderservice.order.OrderService;


@EnableKafka
@Service
public class AddressChangeListener {

    @Autowired
    private OrderService orderService;

    @KafkaListener(
    topics = "userDeliveryAddressChange", 
    containerFactory = "kafkaListenerContainerFactoryAddressChange")
    public void addressChangeListener(AddressChangeMsg addressChangeMsg) {

        System.out.println("Received Message: ["+addressChangeMsg.toString()+"]");
        orderService.updateOrderDeliveryAddress(addressChangeMsg.getUserId(), addressChangeMsg.getDeliveryAddress());
    }
}
