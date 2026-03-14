package com.example.shineshoes.core.Builders;

import com.example.shineshoes.core.DTO.UserDTO;
import jakarta.mail.MessagingException;

public interface UserBuilderInterface
{
    public void build(UserDTO query);
}
