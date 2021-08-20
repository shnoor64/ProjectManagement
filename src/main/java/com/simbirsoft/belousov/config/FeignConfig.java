package com.simbirsoft.belousov.config;

import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@EnableFeignClients(basePackages = "com.simbirsoft.belousov.feign")
public class FeignConfig {

    @Value("${customer.login}")
    private String loggin;
    @Value("${customer.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor  basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(loggin, password);
    }
    @Primary
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    ;
}


