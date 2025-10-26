package com.Highspring.ShoppingCart.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "relatedOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
    private Double totalPrice;
}
