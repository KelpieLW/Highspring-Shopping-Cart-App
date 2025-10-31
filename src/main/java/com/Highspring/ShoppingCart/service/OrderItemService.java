package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.order.EmptyOrderException;
import com.Highspring.ShoppingCart.exceptions.item.InvalidItemQuantityException;
import com.Highspring.ShoppingCart.exceptions.item.InvaliditemPriceException;
import com.Highspring.ShoppingCart.exceptions.item.ItemNotFoundException;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.model.Order;
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
        if (itemIdAddedToOrder==null){
            throw new IllegalArgumentException("Item ID field cannot be null.");
        }

        if (quantity==null){
            throw new IllegalArgumentException("Quantity field cannot be null.");
        }

        if (quantity<=0){
            throw  new InvalidItemQuantityException("You entered an invalid item quantity, the minimum is 1.");
        }

        Item itemAddedToOrder = itemRepository.findById(itemIdAddedToOrder)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + itemIdAddedToOrder));

        if (itemAddedToOrder.getPrice()<1.0){
            throw new InvaliditemPriceException("You've entered an item with a wrong price, there can't be any negative prices.");
        }

        Double discountRate=discountService.calculateDiscount(itemAddedToOrder);
        subTotal+=(itemAddedToOrder.getPrice()*discountRate)+itemAddedToOrder.getPrice();

        OrderItem orderItemToBeAdded=OrderItem.builder().
                orderItem(itemAddedToOrder).
                quantity(quantity).
                build();
        orderItems.add(orderItemToBeAdded);
        return orderItemToBeAdded;
    }

    public Order checkOutItems(){
        if (orderItems.isEmpty()){
            throw new EmptyOrderException("You can't complete an empty order! Please pick some products.");
        }
        Order order=orderService.checkoutOrderItems(orderItems, subTotal);
        orderItems.clear();
        subTotal=0.0;
        return order;
    }
}
