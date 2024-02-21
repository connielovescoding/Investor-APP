package com.invester.usstock.service.finnhub.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.invester.usstock.model.dto.finnhub.StockPriceRealTimeDTO;
import com.invester.usstock.service.finnhub.StockPriceRealTimeService;

@Service
public class StockPriceRealTimeServiceImpl implements StockPriceRealTimeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.finnhub.domain}")
    private String domain;

    @Value("${api.finnhub.base-url}")
    private String baseUrl;

    @Value("${api.finnhub.endpoints.stock.quote}")
    private String quoteEndpoint;
    
    @Value("${api.finnhub.token}")
    private String token;

    @Override
    public StockPriceRealTimeDTO getQuote(String symbol) {
        String url = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .pathSegment(baseUrl)
            .path(quoteEndpoint)
            .queryParam("symbol", symbol)
            .queryParam("token", token)
            .build()
            .toUriString();

        try {
            System.out.println("url=== " + url);
            return restTemplate.getForObject(url, StockPriceRealTimeDTO.class);
        } catch (RestClientException e) {
            System.out.println("Error");
        }
        return null;
    }
    
}
