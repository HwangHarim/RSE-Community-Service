package com.community.core.error.exception.token;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class InvalidAccessTokenException extends BusinessException {

    public InvalidAccessTokenException(ErrorMessage message) {
        super(message);
    }
}
