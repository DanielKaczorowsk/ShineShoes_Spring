package Services;

import Model.Operation.ProductsOperation.OrderOperation;
import Model.Operation.ProductsOperation.OrderOperationInterface;
import Model.Operation.ProductsOperation.UserOperation;

import java.util.function.Supplier;

public enum OrderDate
{
    ORDER_DATE(OrderOperation::new),
    USER_DATE(UserOperation::new),
    ;
    private final Supplier<OrderOperationInterface<?>> supplier;
    OrderDate(Supplier<OrderOperationInterface<?>> supplier)
    {
        this.supplier = supplier;
    }
    OrderOperationInterface<?>  create()
    {
        return supplier.get();
    }
}
