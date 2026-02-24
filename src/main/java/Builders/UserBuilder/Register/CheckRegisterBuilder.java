package Builders.UserBuilder.Register;

import DTO.UserDTO;
import Exceptions.ErrorCode;
import Exceptions.ShopException;
import Repository.UserRepository;

public class CheckRegisterBuilder implements  RegisterBuilderInterface
{
    private final UserRepository userRepository;
    public CheckRegisterBuilder(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public void build(UserDTO query)
    {
        if(!userRepository.existsByEmail(query.getEmail()))
        {
            throw new ShopException(ErrorCode.Email_Used);
        }
        if(!userRepository.existsByName(query.getName()))
        {
            throw new ShopException(ErrorCode.Name_User);
        }
    }
}
