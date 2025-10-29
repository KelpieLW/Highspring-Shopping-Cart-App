package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.service.domain.DiscountServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class DiscountService implements DiscountServiceInterface {
    @Override
    public Double calculateDiscount(Item item) {
        return item.getItemCategory().getDiscountRate();
    }
}
