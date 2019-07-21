package com.example.stress.tester;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class StressConfig {
    @Bean
    public AsyncHttpClient httpClient() {
        return Dsl.asyncHttpClient();
    }
}
