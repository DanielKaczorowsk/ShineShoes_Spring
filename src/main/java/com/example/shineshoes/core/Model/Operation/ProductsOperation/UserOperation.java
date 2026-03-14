package com.example.shineshoes.core.Model.Operation.ProductsOperation;

import com.example.shineshoes.core.DTO.OrderDTO;
import com.example.shineshoes.core.Model.Order;
import com.example.shineshoes.core.Model.Product;
import com.example.shineshoes.core.Model.User;
import com.example.shineshoes.core.Repository.UserRepository;

public class UserOperation implements OrderOperationInterface
{
    private final UserRepository userRepository;
    private OrderDTO query;
    public void query(OrderDTO dto)
    {
        this.query = dto;
    }
    public UserOperation(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public void execute()
    {
        User user = new User();
        user.setId(this.query.idUser);

        if(this.query.idOrder != null)
        {
            Order order = new Order();
            order.setId(this.query.idOrder);
            if(this.query.idProduct != null)
            {
                Product product = new Product();
                product.setId(this.query.idProduct);
                order.withProduct(product);
            }
            user.withOrders(order);
        }
        this.userRepository.save(user);
    }
}
