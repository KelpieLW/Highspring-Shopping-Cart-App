package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.item.InvalidItemCategory;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.service.domain.DiscountServiceInterface;
import org.springframework.stereotype.Service;

/**
 * Calcualtes the discount of a given Item by checking its category, a discount is a percentage that reduces the item price
 */
@Service
public class DiscountService implements DiscountServiceInterface {
    /**
     * Calculates current discount from an {@link Item}
     * @param item discounts can be obtained by checking the discount at an {@link Item} category
     * @return discount rate given by {@link Item} category
     */
    @Override
    public Double calculateDiscount(Item item) {
        if (item.getItemCategory()==null){
            throw new InvalidItemCategory("The item with Id:"+item.getId()+"has an invalid category.");
        }
        return item.getItemCategory().getDiscountRate();
    }
}
