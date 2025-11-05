package com.Highspring.ShoppingCart.repository.jpa;

import com.Highspring.ShoppingCart.model.Order;
import com.Highspring.ShoppingCart.repository.domain.OrderRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for H2 testing database
 */
@Repository
@RequiredArgsConstructor
@Primary
public class JpaOrderRepository implements OrderRepositoryInterface {
    private final SpringRepositoryOrder springRepositoryOrder;
    @Override
    public List<Order> findAll() {
        return springRepositoryOrder.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return springRepositoryOrder.findById(id);
    }

    @Override
    public void save(Order order) {
        springRepositoryOrder.save(order);
    }
}
