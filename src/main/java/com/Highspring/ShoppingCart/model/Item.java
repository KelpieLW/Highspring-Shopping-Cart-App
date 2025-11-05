package com.Highspring.ShoppingCart.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * These Items are previously persisted on an H2 database, these contain the item information, each item can be added to a {@link OrderItem} and given an amount to calculate its subtotal price
 */
@Entity
@Table(name="item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name="item_category", nullable = false)
    private Category itemCategory;
    private String itemImageUrl;
}
