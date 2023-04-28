package com.community.core.error.exception.token;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class NotExpiredTokenException extends BusinessException {

    public NotExpiredTokenException(ErrorMessage message) {
        super(message);
    }
}
