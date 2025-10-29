package com.Highspring.ShoppingCart.service.domain;

import com.Highspring.ShoppingCart.model.Item;
import org.springframework.stereotype.Service;

@Service
public interface DiscountServiceInterface {
    Double calculateDiscount (Item item);
}
