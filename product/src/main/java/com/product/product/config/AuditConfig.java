package com.product.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.domain.AuditorAware;

@Configuration
@EnableJpaAuditing
public class AuditConfig {
    @Bean
    public AuditorAware<Integer> awareRef() {
        return new AuditorConfig();
    }
}
