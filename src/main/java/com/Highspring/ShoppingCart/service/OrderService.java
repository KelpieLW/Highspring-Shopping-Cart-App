package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.exceptions.taxService.TaxServiceError;
import com.Highspring.ShoppingCart.model.Order;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.repository.jpa.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final TaxService taxService;
    private final JpaOrderRepository jpaOrderRepository;
    public void checkoutOrderItems(List<OrderItem> orderItems, Double subTotal) {
        if(taxService.calculateTax()==null){
            throw new TaxServiceError("Tax service is returning an invalid tax rate.");
        }
        Double total=(subTotal*taxService.calculateTax())+subTotal;
        Order order = Order.builder().orderItems(orderItems).subTotalPrice(subTotal).totalPrice(total).build();
        jpaOrderRepository.save(order);

    }
}
