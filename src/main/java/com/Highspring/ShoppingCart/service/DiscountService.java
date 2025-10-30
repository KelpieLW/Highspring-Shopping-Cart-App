package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.item.InvalidItemCategory;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.service.domain.DiscountServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class DiscountService implements DiscountServiceInterface {
    @Override
    public Double calculateDiscount(Item item) {
        if (item.getItemCategory()==null){
            throw new InvalidItemCategory("The item with Id:"+item.getId()+"has an invalid category.");
        }
        return item.getItemCategory().getDiscountRate();
    }
}
