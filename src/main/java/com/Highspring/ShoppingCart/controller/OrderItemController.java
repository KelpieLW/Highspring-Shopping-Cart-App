package com.Highspring.ShoppingCart.controller;

import com.Highspring.ShoppingCart.dto.OrderItemRequest;

import com.Highspring.ShoppingCart.model.Order;
import com.Highspring.ShoppingCart.model.OrderItem;
import com.Highspring.ShoppingCart.service.OrderItemService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.List;

@RestController
@RequestMapping("/v1/api/orderItems")
@RequiredArgsConstructor
@Tag(name = "Order Items", description = "Manage items in a user's order or shopping cart")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Operation(
        summary = "Get all order items from orderItems list in OrderItemService",
        description = "Retrieves all items currently in the shopping cart, ie. items in the orderItems list",
        responses = {
                @ApiResponse(responseCode = "200", description = "List of order items retrieved successfully",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = OrderItem.class))
                )
        }
    )
    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll(){
        List<OrderItem> orderItemList=orderItemService.findAllOrderItem();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @Operation(
            summary = "Request Order creation from OrderItem list",
            description = "Uses OrderItemService checkoutItems method to consolidate an Order based on OrderItem list and a Subtotal invoking OrderService method. Returns the created Order.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order created by OrderService through OrderItemService as intermediary",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Order.class))
                    ),
                    @ApiResponse(responseCode = "400", description="Cannot create an empty order — no items were found in the cart.",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @GetMapping("/checkout")
    public ResponseEntity<Order> requestOrderCreation(){
        Order order=orderItemService.checkOutItems();

        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @Operation(
            summary = "Adds OrderItem to in memory OrderItem list in OrderItemService",
            description = "Adds OrderItem to in memory OrderItem list in OrderItemService, OrderItem is generated with the RequestBody ie. DTO with Item Id  and desired quantity. OrderItemService layer performs parameter verifications (Quantity must be greater than 0, Item must have a valid structure and price) and then adds the newly created OrderItem to the in memory OrderItem list",
            parameters = {
                    @Parameter(name="orderItemRequest", description = "OrderItem DTO object with basic information (Item Id and Item quantity) to create an OrderItem entity ")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OrderItem added to the OrderItem list inside OrderItemService",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = OrderItem.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "The OrderItem to be added is malformed, has an invalid quantity(less than 1) or an invalid price (less than 0)",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    @PostMapping
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItemRequest orderItemRequest){
        OrderItem newOrderItemService=orderItemService.addOrderItem(
            orderItemRequest.getItemId(),
            orderItemRequest.getQuantity()
        );
        return new ResponseEntity<>(newOrderItemService, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Clears all the elements from OrderItem list in OrderItemService",
            description = "Clears the OrderItem list from OrderItemService and sets the Subtotal of a previous shopping cart session to 0.0."
    )
    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearOrderItems(){
        orderItemService.clearItemOrders();
        return ResponseEntity.noContent().build();
    }

}
