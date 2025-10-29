package com.Highspring.ShoppingCart.repository.domain;

import com.Highspring.ShoppingCart.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepositoryInterface {
    List<OrderItem> findAll();
    Optional <OrderItem>findById(Long Id);
    void save (OrderItem orderItem);
}
