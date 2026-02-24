package Model.Operation.ProductsOperation;

import DTO.OrderDTO;
import Model.Order;
import Model.Product;
import Model.User;

import java.util.List;

public class ProductOperation implements OrderOperationInterface
{
    private OrderDTO query;
    public void query(OrderDTO dto)
    {
        this.query = dto;
    }
    @Override
    public void execute()
    {
        Product product = new Product();
        product.setId(this.query.idProduct);

    }
}
