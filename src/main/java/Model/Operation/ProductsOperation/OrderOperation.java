package Model.Operation.ProductsOperation;


import DTO.OrderDTO;
import Model.Order;
import Model.Product;
import Model.User;

import java.util.List;

public class OrderOperation implements OrderOperationInterface
{
    private OrderDTO query;
    public void query(OrderDTO dto)
    {
        this.query = dto;
    }
    @Override
    public void execute()
    {
        Order order = new Order();
        order.setId(this.query.idOrder);
        if(this.query.idUser != null)
        {
            User user = new User();
            user.setId(this.query.idUser);
            order.withUser(user);
        }
        if(this.query.idProduct != null)
        {
            Product product = new Product();
            product.setId(this.query.idProduct);
            order.withProduct(product);
        }

    }
}
