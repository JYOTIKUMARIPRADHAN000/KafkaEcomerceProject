package com.kafkaEcomerce.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.kafkaEcomerce.order.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
