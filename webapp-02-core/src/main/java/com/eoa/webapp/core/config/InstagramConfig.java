package com.eoa.webapp.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "instagram")
@Getter
@Setter
public class InstagramConfig {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
