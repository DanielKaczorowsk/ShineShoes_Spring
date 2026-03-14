package com.example.shineshoes.core.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode
{
    EMPTY_DTO(HttpStatus.NOT_FOUND,"Empty record in DTO"),
    Empty_Class(HttpStatus.BAD_REQUEST,"Class not found"),
    Empty_Array(HttpStatus.BAD_REQUEST,"invaild array arguments"),
    Email_Used(HttpStatus.CONFLICT,"Email is already in use"),
    Name_User(HttpStatus.CONFLICT,"Name is already in use"),
    Email_Error(HttpStatus.CONFLICT,"Can't send email");

    private final HttpStatus status;
    private final String message;
    ErrorCode(HttpStatus status , String message){
        this.status = status;
        this.message = message;
    }
}
