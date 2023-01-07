package com.dansmulti.test.test2dan3;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@Configuration
@RequiredArgsConstructor
public class RestTemplate {
    private final ReadTimeOutProperties readTimeOutProperties;

    private final ConnectionTimeOutProperties connectionTimeOutProperties;


    @Bean
    @Qualifier("ServiceRestTemplate")
    public org.springframework.web.client.RestTemplate getInterServiceRestTemplate() {
        return new RestTemplateBuilder()
                .setReadTimeout(Duration.ofMillis(readTimeOutProperties.base))
                .setConnectTimeout(Duration.ofMillis(connectionTimeOutProperties.base))
                .build();
    }

}
