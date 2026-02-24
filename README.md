## Table of contents
- Folder structure
- Login/Register
- Custom Exception
- License
## Login/Register
Director (UserDirector): Orchestrates the execution of the build process.

Builder (UserBuilderInterface): Individual steps (e.g., password checking, JWT generation) implemented as modular components.

Factory: Dynamically selects the required builders based on the action (Login vs. Registration).

Key Features
JWT Authentication: Secure token generation using jjwt.

Stateless Security: Fully integrated with Spring Security for API protection.

Modular Validation: Decoupled login checks (BCrypt) and email verification.

Tech Stack
Spring Boot 4 | Spring Security | JJWT | PostgreSQL

## Custom Exception
Custom Exception in GlobalExceptionHandler
```java
@ExceptionHandler(ShopException.class)
    public ResponseEntity<ExceptionDTO> handleShopException(ShopException ex)
    {
        ErrorCode error = ex.getErrorCode();
        BuildExceptionDTO builderDTO = new BuildExceptionDTO();
        ExceptionDTO dto = builderDTO.message(error.getMessage())
                .status(error.getStatus())
                .timestamp(LocalDateTime.now())
                .get();

        return ResponseEntity.status(error.getStatus()).body(dto);
    }
```

## Folder Structure
src/
- main/java/
  - Builders/
  	- UserBuilders/
  - com.example.shineshoes/          
  - Controllers/         
  - DTO/          
  - Exceptions/              
  - Factory/
  - Model/
  	- Operation/
   		- ProductsOperation/
  - Repository/
  - Services/
- resources/
## License

This project is licensed under the MIT License — see LICENSE for details.
