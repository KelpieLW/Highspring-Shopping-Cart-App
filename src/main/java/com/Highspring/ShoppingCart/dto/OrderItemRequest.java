package com.Highspring.ShoppingCart.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO made for adding new OrderItems from the Controller endpoint
 */
@Getter
@Setter
public class OrderItemRequest {
    private Long itemId;
    private Long quantity;

}
