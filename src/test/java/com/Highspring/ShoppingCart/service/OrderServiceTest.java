package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.order.EmptyOrderException;
import com.Highspring.ShoppingCart.exceptions.taxService.TaxServiceError;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.model.Order;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.repository.jpa.JpaOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private JpaOrderRepository jpaOrderRepository;
    @Mock
    private TaxService taxService;
    @InjectMocks
    private OrderService orderService;

    private List<OrderItem> sampleOrderItemList(){
        Item sampleItem =Item.builder().id(2L).name("Order_test_item").price(30.06).build();
        OrderItem sampleOrderItem=OrderItem.builder().id(1L).orderItem(sampleItem).quantity(90L).build();
        return List.of(sampleOrderItem);
        }

    @Test
    void checkoutOrderItems_shouldCreateOrder_whenGivenACorrectOrderItemList(){
        List<OrderItem> orderItems = sampleOrderItemList();
        double subTotal = 200.0;
        when(taxService.calculateTax()).thenReturn(0.1); // 10% tax

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);

        orderService.checkoutOrderItems(orderItems, subTotal);

        verify(taxService, times(1)).calculateTax();
        verify(jpaOrderRepository, times(1)).save(orderCaptor.capture());

        Order savedOrder = orderCaptor.getValue();
        assertEquals(subTotal, savedOrder.getSubTotalPrice());
        assertEquals(subTotal * 1.1, savedOrder.getTotalPrice()); // 200 * 1.1 = 220
        assertEquals(orderItems, savedOrder.getOrderItems());

    }
    @Test
    void checkoutOrderItems_shouldThrowException_whenTaxServiceNotWorking(){
        List<OrderItem> orderItems = sampleOrderItemList();
        double subTotal = 200.0;
        when(taxService.calculateTax()).thenReturn(null);

        assertThrows(TaxServiceError.class, ()-> orderService.checkoutOrderItems(orderItems,200.00));
        verifyNoInteractions(jpaOrderRepository);
    }

}
