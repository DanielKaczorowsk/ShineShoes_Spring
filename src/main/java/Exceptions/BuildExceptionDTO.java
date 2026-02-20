package Exceptions;

import DTO.ExceptionDTO;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class BuildExceptionDTO
{
    private ExceptionDTO query;

    public void reset()
    {
        this.query = new ExceptionDTO();
    }
    public BuildExceptionDTO errorCode(String errorCode)
    {
        this.query.errorCode = errorCode;
        return this;
    }
    public BuildExceptionDTO message(String message)
    {
        this.query.message = message;
        return this;
    }
    public BuildExceptionDTO status(HttpStatus status)
    {
        this.query.status = status;
        return this;
    }
    public BuildExceptionDTO timestamp(LocalDateTime timestamp)
    {
        this.query.timestamp = timestamp;
        return this;
    }
    public ExceptionDTO get()
    {
        return this.query;
    }
}
