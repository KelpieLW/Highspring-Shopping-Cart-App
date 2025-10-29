package com.Highspring.ShoppingCart.repository.jpa;

import com.Highspring.ShoppingCart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepositoryOrder extends JpaRepository<Order, Long> {

}
