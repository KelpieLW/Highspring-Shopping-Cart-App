package com.Highspring.ShoppingCart.repository.jpa;

import com.Highspring.ShoppingCart.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepositoryOrderItem extends JpaRepository<OrderItem, Long> {

}
