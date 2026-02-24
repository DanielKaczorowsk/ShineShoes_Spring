package Model.Operation.ProductsOperation;

import DTO.OrderDTO;
import Model.Order;
import Model.Product;
import Model.User;
import Repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
