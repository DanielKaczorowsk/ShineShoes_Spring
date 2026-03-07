package DTO;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionDTO
{
    public String errorCode;
    public String message;
    public HttpStatus status;
    public LocalDateTime timestamp;

}
