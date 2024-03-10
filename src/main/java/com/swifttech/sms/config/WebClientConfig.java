package com.swifttech.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {



    @Bean
    private WebClient.Builder webClient(){
        return WebClient.builder();
    }

}
