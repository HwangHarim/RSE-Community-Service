package com.community.core.error.exception.oauth;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.BusinessException;

public class OAuthProviderMissMatchException extends BusinessException {

    public OAuthProviderMissMatchException(ErrorMessage message) {
        super(message);
    }
}
