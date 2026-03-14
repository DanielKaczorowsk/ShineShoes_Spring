package com.example.shineshoes.core.Model.Operation.ProductsOperation;

import com.example.shineshoes.core.DTO.OrderDTO;
import com.example.shineshoes.core.Model.Product;

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
