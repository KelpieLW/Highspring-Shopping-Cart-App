package com.Highspring.ShoppingCart.repository.jpa;

import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.repository.domain.ItemRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Primary
public class JpaItemRepository implements ItemRepositoryInterface {

    private final SpringRepositoryItem springRepositoryItem;
    @Override
    public List<Item> findAll() {
        return springRepositoryItem.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return springRepositoryItem.findById(id);
    }
}
