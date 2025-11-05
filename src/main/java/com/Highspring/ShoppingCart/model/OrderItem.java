package com.Highspring.ShoppingCart.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Intermediary object, contains both the {@link Item} and quantity soon to be added to an {@link Order}, an Order can be composed of several OrderItem.
 * OrderItems get persisted only after an Order is created.
 */
@Entity
@Table(name="order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "item_id", nullable=false)
    private Item orderItem;
    private Long quantity;
}
