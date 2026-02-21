package Model.Operation;

import Model.Order;

import java.util.List;

public interface OperationInterface<T>
{
    public List<T> execute();
}