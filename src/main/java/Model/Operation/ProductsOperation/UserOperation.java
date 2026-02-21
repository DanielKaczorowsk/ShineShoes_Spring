package Model.Operation.ProductsOperation;

import DTO.OrderDTO;
import Model.Order;
import Model.Product;
import Model.User;

import java.util.List;

public class UserOperation implements OrderOperationInterface
{
    private OrderDTO query;
    public void query(OrderDTO dto)
    {
        this.query = dto;
    }
    @Override
    public List<User> execute()
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

        return List.of(user);
    }
}
