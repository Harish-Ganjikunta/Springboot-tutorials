package com.hari.cloud.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnlineMobilesConfig {

    @Bean
    public Sampler defaultSampler() {
        // This method is used to configure the sampling rate for tracing.
        // Returning Sampler.ALWAYS_SAMPLE means that all requests will be sampled.
        return Sampler.ALWAYS_SAMPLE;
    }
}
