package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.taxService.TaxServiceError;
import com.Highspring.ShoppingCart.model.Order;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Manages the Order creation from a list of OrderItem,  Subtotal and a calculated tax rate that represents the total price of the purchase.
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final TaxService taxService;
    private final JpaOrderRepository jpaOrderRepository;

    /**
     * Consolidates an Order from a list of OrderItems, a subtotal value and a tax rate calculated from {@link TaxService}
     * @param orderItems {@link OrderItem} list passed from {@link OrderItemService}, contains information about items and item quantity
     * @param subTotal Sum of prices from all the items within each {@link OrderItem} within orderItems
     * @return consolidated {@link Order} made from a list of {@link OrderItem} and subtotal, this {@link Order} contains the total price of the purchase
     */
    public Order checkoutOrderItems(List<OrderItem> orderItems, Double subTotal) {
        Double taxRate=taxService.calculateTax();
        if(taxRate==null){
            throw new TaxServiceError("Tax service is returning an invalid tax rate.");
        }
        Double total=(subTotal*taxRate)+subTotal;
        Order order = Order.builder().orderItems(orderItems).subTotalPrice(subTotal).totalPrice(total).taxValue(taxRate).build();
        jpaOrderRepository.save(order);
        return order;

    }
}