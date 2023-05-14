package com.community.core.error.exception.token;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class InvalidRefreshTokenException extends BusinessException {

    public InvalidRefreshTokenException(ErrorMessage message) {
        super(message);
    }
}
