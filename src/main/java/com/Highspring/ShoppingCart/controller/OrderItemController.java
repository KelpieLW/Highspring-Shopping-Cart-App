package com.Highspring.ShoppingCart.controller;

import com.Highspring.ShoppingCart.dto.OrderItemRequest;
import com.Highspring.ShoppingCart.model.Item;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/orderItems")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;
    @PostMapping
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItemRequest orderItemRequest){
        OrderItem newOrderItemService=orderItemService.addOrderItem(
            orderItemRequest.getItemId(),
            orderItemRequest.getQuantity()
        );
        return new ResponseEntity<>(newOrderItemService, HttpStatus.CREATED);
    }

}
