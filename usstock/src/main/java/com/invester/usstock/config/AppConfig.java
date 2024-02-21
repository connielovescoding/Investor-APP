package com.invester.usstock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.invester.usstock.model.mapper.AlphavantageMapper;
import com.invester.usstock.model.mapper.FinnhubMapper;

@Configuration
public class AppConfig {
    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    FinnhubMapper finnhubMapper() {
        return new FinnhubMapper();
    }

    @Bean
    AlphavantageMapper alphavantageMapper() {
        return new AlphavantageMapper();
    }
}
