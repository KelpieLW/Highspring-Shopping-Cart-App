package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.item.InvalidItemQuantityException;
import com.Highspring.ShoppingCart.exceptions.item.InvaliditemPriceException;
import com.Highspring.ShoppingCart.exceptions.item.ItemNotFoundException;
import com.Highspring.ShoppingCart.exceptions.order.EmptyOrderException;
import com.Highspring.ShoppingCart.model.Category;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.repository.jpa.JpaItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderItemServiceTest {
    @Mock private JpaItemRepository itemRepository;
    @Mock private DiscountService discountService;
    @Mock private OrderService orderService;
    @InjectMocks private OrderItemService orderItemService;
    private Item itemSample (Long id, String name, Double price){
        Item sampleItemResult = Item.builder().id(id).name(name).price(price).build();
        return sampleItemResult;
    }

    @Test
    void addOrderItem_shouldCreateOrderItem_whenGivenValidParameters(){
        Item item=itemSample(1L, "Test_Item", 29.99);
        Long quantity=2L;
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        when(discountService.calculateDiscount(item)).thenReturn(0.1);

        OrderItem result=orderItemService.addOrderItem(1L, quantity);

        verify(discountService, times(1)).calculateDiscount(item);
        verify(itemRepository, times(1)).findById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getOrderItem()).isEqualTo(item);
        assertThat(result.getQuantity()).isEqualTo(quantity);
    }

    @Test
    void addOrderItem_shouldThrowException_whenGivenANonExistentItem(){
        when(itemRepository.findById(6L)).thenReturn(Optional.empty());

        assertThrows(ItemNotFoundException.class, ()-> orderItemService.addOrderItem(6L, 6L));

        verify(itemRepository, times(1)).findById(6L);
        verifyNoInteractions(discountService);
    }

    @Test
    void addOrderItem_shouldThrowException_whenGivenANullItemId(){
        assertThrows(IllegalArgumentException.class,()->orderItemService.addOrderItem(null,20L));
        verifyNoInteractions(itemRepository);
        verifyNoInteractions(discountService);
    }

    @Test
    void addOrderItem_shouldThrowException_whenGivenAnInvalidQuantity(){
        assertThrows(InvalidItemQuantityException.class,()->orderItemService.addOrderItem(1L,-2L));
        verifyNoInteractions(discountService);
        verifyNoInteractions(itemRepository);
    }

    @Test
    void addOrderItem_shouldThrowException_whenAnItemHasANegativePrice(){
        Item item=itemSample(9L, "Test_Item", -999.99);
        when(itemRepository.findById(9L)).thenReturn(Optional.of(item));

        assertThrows(InvaliditemPriceException.class, ()-> orderItemService.addOrderItem(9L,2L));

        verify(itemRepository, times(1)).findById(9L);
    }

    @Test
    void checkOutItems_shouldThrowException_whenTryingToCompleteAnEmptyOrder(){
        assertThrows(EmptyOrderException.class, ()-> orderItemService.checkOutItems());
        verifyNoInteractions(itemRepository);
        verifyNoInteractions(discountService);
    }
}
