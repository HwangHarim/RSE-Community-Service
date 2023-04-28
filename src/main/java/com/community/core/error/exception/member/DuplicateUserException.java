package com.community.core.error.exception.member;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class DuplicateUserException extends BusinessException {

    public DuplicateUserException(ErrorMessage message) {
        super(message);
    }
}
