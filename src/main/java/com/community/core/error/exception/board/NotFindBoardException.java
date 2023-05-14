package com.community.core.error.exception.board;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class NotFindBoardException extends BusinessException {
    public NotFindBoardException(ErrorMessage message) {
        super(message);
    }
}
