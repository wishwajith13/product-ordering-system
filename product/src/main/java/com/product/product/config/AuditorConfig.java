package com.product.product.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

public class AuditorConfig implements AuditorAware<Integer> {
    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.of(200);
    }
}
