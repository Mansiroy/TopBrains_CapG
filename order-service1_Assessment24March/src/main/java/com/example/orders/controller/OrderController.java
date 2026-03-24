package com.example.orders.controller;

import com.example.orders.dto.OrderRequestDTO;

import com.example.orders.entity.OrderEntity;
import com.example.orders.service.OrderService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(
            @Valid @RequestBody OrderRequestDTO request) {
        OrderEntity order = service.createOrder(request);
        Map<String, Object> response = buildResponse(order);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getOrder(@PathVariable Long id) {
		OrderEntity order = service.getOrderById(id);
		return ResponseEntity.ok(buildResponse(order));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		service.deleteOrder(id);
		return ResponseEntity.ok("Order deleted successfully");
	}

	private Map<String, Object> buildResponse(OrderEntity order) {
		Map<String, Object> map = new HashMap<>();

		map.put("orderId", order.getId()); // IMPORTANT (test expects this)
		map.put("customerName", order.getCustomerName());
		map.put("email", order.getEmail());
		map.put("productName", order.getProductName());
		map.put("quantity", order.getQuantity());
		map.put("pricePerUnit", order.getPricePerUnit());
		map.put("totalAmount", order.getTotalAmount());

		return map;
	}
}