package com.community.core.error.exception.token;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class TokenValidFailedException extends BusinessException {

    public TokenValidFailedException(ErrorMessage message) {
        super(message);
    }
}