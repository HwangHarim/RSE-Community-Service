package com.community.core.error.exception.oauth;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class NoAuthException extends BusinessException {
    public NoAuthException(ErrorMessage message) {
        super(message);
    }
}
