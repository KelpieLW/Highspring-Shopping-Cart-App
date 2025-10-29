package com.Highspring.ShoppingCart.model;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order relatedOrder;
}
