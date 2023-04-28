package com.community.core.config.properties;

import com.community.core.common.properties.AppProperties;
import com.community.core.common.properties.CorsProperties;
import com.community.core.common.properties.SlackProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
    CorsProperties.class,
    AppProperties.class,
    SlackProperties.class
})
@Configuration
public class ConfigurationProperties {

}
