package com.example.shineshoes.core.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Basket")
@NoArgsConstructor
@Getter
@Setter
public class BasketItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
    private int quantity;
}
