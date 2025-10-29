package com.Highspring.ShoppingCart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private Long itemId;
    private Long quantity;

}
