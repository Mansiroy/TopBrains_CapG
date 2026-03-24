package com.example.orders.service;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.exception.OrderNotFoundException;
import com.example.orders.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public OrderEntity createOrder(OrderRequestDTO request) {
    	
        OrderEntity entity = new OrderEntity();
        entity.setCustomerName(request.getCustomerName());
        entity.setEmail(request.getEmail());
        entity.setProductName(request.getProductName());
        entity.setQuantity(request.getQuantity());
        entity.setPricePerUnit(request.getPricePerUnit());

        double total = request.getQuantity() * request.getPricePerUnit();
        entity.setTotalAmount(total);

        return repository.save(entity);
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public void deleteOrder(Long id) {

        if (!repository.existsById(id)) {
            throw new OrderNotFoundException();
        }

        repository.deleteById(id);
   }
}

