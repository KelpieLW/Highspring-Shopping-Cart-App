package com.Highspring.ShoppingCart.controller;

import com.Highspring.ShoppingCart.dto.OrderItemRequest;

import com.Highspring.ShoppingCart.model.Order;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.service.OrderItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/api/orderItems")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll(){
        List<OrderItem> orderItemList=orderItemService.findAllOrderItem();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @GetMapping("/checkout")
    public ResponseEntity<Order> requestOrderCreation(){
        Order order=orderItemService.checkOutItems();
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItemRequest orderItemRequest){
        OrderItem newOrderItemService=orderItemService.addOrderItem(
            orderItemRequest.getItemId(),
            orderItemRequest.getQuantity()
        );
        return new ResponseEntity<>(newOrderItemService, HttpStatus.CREATED);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearOrderItems(){
        orderItemService.clearItemOrders();
        return ResponseEntity.noContent().build();
    }

}
