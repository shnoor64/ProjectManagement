package com.simbirsoft.belousov.config;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.simbirsoft.belousov.feign")
public class FeignConfig {

    @Value("${customer.login}")
    private String loggin;
    @Value("${customer.password}")
    private String password;

    @Bean
    @ConditionalOnProperty(value = "application.security.enabled", havingValue = "true")
    public RequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(loggin, password);
    }

    ;
}


