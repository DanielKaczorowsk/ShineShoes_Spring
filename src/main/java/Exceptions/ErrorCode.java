package Exceptions;

import org.springframework.http.HttpStatus;

public enum ErrorCode
{
    EMPTY_DTO(HttpStatus.NOT_FOUND,"Empty record in DTO"),
    Empty_Class(HttpStatus.BAD_REQUEST,"Class not found"),
    Empty_Array(HttpStatus.BAD_REQUEST,"invaild array arguments");

    private final HttpStatus status;
    private final String message;
    ErrorCode(HttpStatus status , String message){
        this.status = status;
        this.message = message;
    }
    public HttpStatus getStatus()
    {
        return this.status;
    }
    public String getMessage() {
        return this.message;
    }
}
