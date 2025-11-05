package com.Highspring.ShoppingCart.repository.jpa;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.repository.domain.OrderItemRepositoryInterface;
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
public class JpaOrderItemRepository implements OrderItemRepositoryInterface {

    private final SpringRepositoryOrderItem springRepositoryOrderItem;
    @Override
    public List<OrderItem> findAll() {
        return springRepositoryOrderItem.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return springRepositoryOrderItem.findById(id);
    }

    @Override
    public void save(OrderItem orderItem) {
        springRepositoryOrderItem.save(orderItem);
    }
}
