package com.Highspring.ShoppingCart.repository.domain;

import com.Highspring.ShoppingCart.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepositoryInterface{

    List<Item> findAll();
    Optional<Item> findById(Long id);

}
