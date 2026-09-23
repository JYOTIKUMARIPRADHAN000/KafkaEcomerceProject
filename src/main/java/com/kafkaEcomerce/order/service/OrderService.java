package com.kafkaEcomerce.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkaEcomerce.order.entity.OrderEntity;
import com.kafkaEcomerce.order.repository.OrderRepository;
import com.kafkaEcomerce.order.request.OrderRequest;
import com.kafkaEcomerce.order.response.OrderResponse;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public OrderResponse createOrder(OrderRequest orderRequest) {

		OrderEntity reqEntity = new OrderEntity();

		reqEntity.setCustomerId(orderRequest.getCustomerId());
		reqEntity.setCustomerName(orderRequest.getCustomerName());
		reqEntity.setProductId(orderRequest.getProductId());
		reqEntity.setProductName(orderRequest.getProductName());
		reqEntity.setQuantity(orderRequest.getQuantity());
		reqEntity.setAmount(orderRequest.getAmount());
		long reqProductId = orderRequest.getProductId();
		if (reqProductId != 0) {
			reqEntity.setStatus("placed");
		} else {
			reqEntity.setStatus("not placed");
		}

		reqEntity.setDeliveryAddress(orderRequest.getDeliveryAddress());

		OrderEntity orderResEntity = orderRepository.save(reqEntity);

		OrderResponse response = new OrderResponse();

		response.setOrderId(orderResEntity.getOrderId());
		response.setStatus(orderResEntity.getStatus());

		return response;

	}

}
