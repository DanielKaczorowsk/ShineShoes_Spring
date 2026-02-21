## 📁 Folder Structure
	src/
    ├── main/java/
    │   ├── Controllers/   
    │   ├── DTO/
    │   ├── Exceptions/
    │   ├── Model/
    │	├── Services/
    │   └── resources/
    │       ├── templates/   
    │       └── static/
    └── test/     
## Order Module

### Order
- `id` (PK)
- `user` (Many-to-One → User)
- `products` (Many-to-Many → Product)
- `status` (String)
- Builder-style: `withUser()`, `withProduct()`, `withStatus()`

### User
- `id`, `name`, `email`
- One-to-Many → Order (`orders` list)

### Product
- `id`, `name`, `price`
- Many-to-Many ↔ Order (`orders` list)

### OrderDTO
- `idOrder` – ID order
- `idUser` – ID user
- `idProduct` – ID Product 
- `nameProduct` – optional filter

### OrderOperationInterface<T>
- Metoda `execute()` zwraca List<T>
- Implement: `OrderOperation`, `UserOperation`, `ProductOperation`
- `OrderService` use builder-style for setting fields DTO and return operation

### OrderDate
- Enum use to fabric operation
- Example: `OrderDate.ORDER_DATE.create()` return `OrderOperation`