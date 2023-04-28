package com.community.core.oauth.info;

import com.community.core.oauth.domain.ProviderType;
import com.community.core.oauth.info.impl.GoogleOAuth2UserInfo;
import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(ProviderType providerType, Map<String, Object> attributes) {
        if (providerType == ProviderType.GOOGLE) {
            return new GoogleOAuth2UserInfo(attributes);
        }
        throw new IllegalArgumentException("Invalid Provider Type.");
    }
}