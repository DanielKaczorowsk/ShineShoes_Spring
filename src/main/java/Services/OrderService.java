package Services;

import DTO.OrderDTO;
import Model.Operation.ProductsOperation.OrderOperationInterface;

public class OrderService
{
    private OrderDTO query;
    private final OrderDate orderDate;
    public void reset()
    {
        this.query = new OrderDTO();
    }
    public OrderService(OrderDate orderDate)
    {
        this.orderDate = orderDate;
        this.reset();
    }
    public OrderService idUser(Integer idUser)
    {
        this.query.idUser = idUser;
        return this;
    }
    public OrderService idOrder(Integer idOrder)
    {
        this.query.idOrder = idOrder;
        return this;
    }
    public OrderService idProduct(Integer idProduct)
    {
        this.query.idProduct = idProduct;
        return this;
    }
    public OrderService nameProduct(String nameProduct)
    {
        this.query.nameProduct = nameProduct;
        return this;
    }

    public int get()
    {
        OrderOperationInterface operation = this.orderDate.create();
        return 0;
    }
}
