package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.ItemNotFoundException;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.repository.jpa.JpaItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final JpaItemRepository itemRepository;
    private final DiscountService discountService;
    private final OrderService orderService;
    private final List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private Double subTotal=0.0;

    public OrderItem addOrderItem(Long itemIdAddedToOrder, Long quantity){
        Item itemAddedToOrder = itemRepository.findById(itemIdAddedToOrder)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + itemIdAddedToOrder));
        subTotal+=(itemAddedToOrder.getPrice()*discountService.calculateDiscount(itemAddedToOrder))+itemAddedToOrder.getPrice();

        OrderItem orderItemToBeAdded=OrderItem.builder().
                orderItem(itemAddedToOrder).
                quantity(quantity).
                build();
        orderItems.add(orderItemToBeAdded);
        return orderItemToBeAdded;
    }

    public void checkOutItems(){
        orderService.checkoutOrderItems(orderItems, subTotal);
        orderItems.clear();
        subTotal=0.0;
    }
}
