package com.community.core.error.exception.image;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class InvalidArgumentException extends BusinessException {

    public InvalidArgumentException(ErrorMessage message) {
        super(message);
    }
}
