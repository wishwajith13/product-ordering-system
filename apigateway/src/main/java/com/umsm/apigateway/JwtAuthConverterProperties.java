package com.umsm.apigateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtClaimNames;

@Configuration
@ConfigurationProperties(prefix = "jwt.auth.converter")
public class JwtAuthConverterProperties {

    private String resourceId;
    private String principleAttribute = JwtClaimNames.SUB; // default

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getPrincipleAttribute() {
        return principleAttribute;
    }

    public void setPrincipleAttribute(String principleAttribute) {
        this.principleAttribute = principleAttribute;
    }
}

