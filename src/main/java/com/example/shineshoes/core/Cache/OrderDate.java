package com.example.shineshoes.core.Cache;

import com.example.shineshoes.core.Model.Operation.ProductsOperation.OrderOperation;
import com.example.shineshoes.core.Model.Operation.ProductsOperation.OrderOperationInterface;

import java.util.function.Supplier;

public enum OrderDate
{
    ORDER_DATE(OrderOperation::new),
    ;
    private final Supplier<OrderOperationInterface> supplier;
    OrderDate(Supplier<OrderOperationInterface> supplier)
    {
        this.supplier = supplier;
    }
    public OrderOperationInterface  create()
    {
        return supplier.get();
    }
}
