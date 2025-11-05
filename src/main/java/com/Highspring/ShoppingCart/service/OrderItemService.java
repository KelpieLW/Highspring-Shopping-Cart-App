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

/**
 * Service class responsible for managing OrderItem operations such as
 * adding items to an order, clearing items, and checking out an order.
 * <p>
 *  This class acts as an intermediary between the controller and the repository layers,
 *  enforcing business rules and validation before persisting or transforming data.
 * </p>
 */


@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final JpaItemRepository itemRepository;
    private final DiscountService discountService;
    private final OrderService orderService;
    private final List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private Double subTotal=0.0;

    /**
     * Returns in memory orderItem list. This is an in memory that saves the added shopping cart Order items
     * @return a list of {@link OrderItem}
     */
    public List<OrderItem> findAllOrderItem(){
        return orderItems;
    }

    /**
     * Adds an Order Item to an OrderItem list and returns the latest added OrderItem
     * @param itemIdAddedToOrder identification number (Long) for the {@link  Item} to be used for the {@link  OrderItem} object to be added to the list
     * @param quantity amount of {@link Item} related to an OrderItem
     * @return a {@link OrderItem} of the OrderItem currently added to the in memory list
     */
    public OrderItem addOrderItem(Long itemIdAddedToOrder, Long quantity){
        if (itemIdAddedToOrder==null){
            throw new IllegalArgumentException("Item ID field cannot be null.");
        }

        if (quantity==null){
            throw new IllegalArgumentException("Quantity field cannot be null.");
        }

        if (quantity<=0){
            throw  new InvalidItemQuantityException("You've entered an invalid item quantity, the minimum is 1.");
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

    /**
     * Passes the OrderItem list and Subtotal (sum of all the prices from all the items inside the OrderItem List) to Order service to perform the checkout with the current Order Item List
     * @return the {@link  Order} created by the {@link OrderService} from the {@link OrderItem} list
     */
    public Order checkOutItems(){

        if (orderItems.isEmpty()){
            throw new EmptyOrderException("You can't complete an empty order! Please pick some products.");
        }

        return orderService.checkoutOrderItems(orderItems, subTotal);
    }

    /**
     * Clears the OrderItem list (orderItems) from all its elements and updates subTotal to 0.0
     */
    public void clearItemOrders(){
        orderItems.clear();
        subTotal=0.0;
    }
}
