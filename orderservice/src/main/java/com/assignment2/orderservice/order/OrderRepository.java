package com.assignment2.orderservice.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment2.orderservice.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {

	@Query("{'order_status' : ?0 }")
	Optional<List<Order>> findByState(String state);

	@Query("{'user_id' : ?0 }")
	Optional<List<Order>> findOrdersByUserId(int user_id);

	@Query("{'_id' : ?0 }")
	Optional<Order> findByOrderId(int orderId);
}
