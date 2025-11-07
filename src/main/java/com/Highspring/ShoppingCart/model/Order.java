package com.Highspring.ShoppingCart.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * An Order is composed of an {@link OrderItem} list, subtotal and total values calculated over the OrderItem list, the subtotal is the sum of all the item prices multiplied by a respective amount, total is the subtotal price plus the tax value
 */
@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;
    private Double taxValue;
    private Double subTotalPrice;
    private Double totalPrice;
}
