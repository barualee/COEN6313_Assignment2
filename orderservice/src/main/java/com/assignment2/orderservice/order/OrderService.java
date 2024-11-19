package com.assignment2.orderservice.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment2.orderservice.entities.DeliveryAddress;
import com.assignment2.orderservice.entities.Order;
import com.assignment2.orderservice.errorhandling.AlreadyExistsException;
import com.assignment2.orderservice.errorhandling.NotFoundException;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepository;
    
    public List<Order> getOrdersByState(String state){
        List<Order> orderList = orderRepository.findByState(state).get();

        if(orderList.size() == 0){
            throw new NotFoundException("Orders with shipping status: "+state+" not found");
        }
        return orderList;
        
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order createOrder(Order order){
        Order fetchOrder = orderRepository.findByOrderId(order.getOrderId()).get();
        System.out.println(order.getOrderId());
        if(fetchOrder == null){
            return saveOrder(order);
        }
        throw new AlreadyExistsException("Order with Order ID: "+order.getOrderId()+" already exist");
    }

    public Order updateOrderStatus(int orderId, String status) {
        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isPresent()){
            Order fetchOrder = order.get();
            fetchOrder.setOrderStatus(status);
            return orderRepository.save(fetchOrder);
        }
        throw new NotFoundException("Order with Order ID: "+orderId+" not found");
    }

    public List<Order> updateOrderDeliveryAddress(int user_id, DeliveryAddress deliveryAddress) {
        List<Order> fetchOrdersList = orderRepository.findOrdersByUserId(user_id).get();

        if (fetchOrdersList.size() > 0){
            for(Order curorder : fetchOrdersList){
                curorder.setDeliveryAddress(deliveryAddress);
                saveOrder(curorder);
            }
            return fetchOrdersList;
        }
        throw new NotFoundException("No Orders found for User ID: "+user_id);
    }

    public List<Order> updateOrderEmails(int user_id, String[] emails) {
        List<Order> fetchOrdersList = orderRepository.findOrdersByUserId(user_id).get();

        if (fetchOrdersList.size() > 0){
            for(Order curorder : fetchOrdersList){
                curorder.setUserEmails(emails);
                saveOrder(curorder);
            }
            return fetchOrdersList;
        }
        throw new NotFoundException("No Orders found for User ID: "+user_id);
    }
}
