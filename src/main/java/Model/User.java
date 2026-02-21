package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
    public User() {}

    public User(String name, String email)
    {
        this.name = name;
        this.email = email;
    }
    public User withOrders(Order order)
    {
        this.orders.add(order);
        return this;
    }
}
