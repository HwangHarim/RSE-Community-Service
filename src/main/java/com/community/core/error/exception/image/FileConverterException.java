package com.community.core.error.exception.image;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class FileConverterException extends BusinessException {

    public FileConverterException(ErrorMessage message) {
        super(message);
    }
}
