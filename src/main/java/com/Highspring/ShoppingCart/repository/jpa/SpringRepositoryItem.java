package com.Highspring.ShoppingCart.repository.jpa;

import com.Highspring.ShoppingCart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepositoryItem extends JpaRepository<Item, Long> {

}
