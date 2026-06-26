package com.example.shineshoes.core.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Basket")
@NoArgsConstructor
@Getter
@Setter
public class Basket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "basket",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BasketItem> items = new ArrayList<>();
    public void withProduct(Product products,int quantity)
    {
        BasketItem basketitem = new BasketItem();
        basketitem.setBasket(this);
        basketitem.setProduct(products);
        basketitem.setQuantity(quantity);
        this.items.add(basketitem);
    }
    public void withUser(User user)
    {
        this.user = user;
    }
}
