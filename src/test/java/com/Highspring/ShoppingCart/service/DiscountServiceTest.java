package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.item.InvalidItemCategory;
import com.Highspring.ShoppingCart.model.Category;
import com.Highspring.ShoppingCart.model.Item;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {
    @InjectMocks
    private DiscountService discountService;
    private Category categorySample(){
        return Category.builder().id(1L).name("Discount_Service_Category_Test").discountRate(0.15).build();
    }
    private Item itemSample (Category category){
        Item sampleItemResult = Item.builder().id(5L).name("Discount_Service_Item_Test").price(69.00).itemCategory(category).build();
        return sampleItemResult;
    }
    @Test
    void calculateDiscount_shouldReturnDiscountRate_givenAValidItem(){
        Item item=itemSample(categorySample());
        assertEquals(discountService.calculateDiscount(item),item.getItemCategory().getDiscountRate());
    }

    @Test
    void calculateDiscount_shouldThrowException_whenGivenAnInvalidItem(){
        Item item=itemSample(null);
        assertThrows(InvalidItemCategory.class,() -> discountService.calculateDiscount(item));
    }
}
