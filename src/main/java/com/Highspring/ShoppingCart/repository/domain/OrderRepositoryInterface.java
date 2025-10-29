package com.Highspring.ShoppingCart.repository.domain;

import com.Highspring.ShoppingCart.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepositoryInterface {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    void save(Order order);
}
