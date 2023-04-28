package com.community.core.error.exception;

import com.community.core.error.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage message){
        super(message.getMessage());
        this.errorMessage = message;
    }
}