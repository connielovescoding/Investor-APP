package com.invester.usstock.service.finnhub.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.invester.usstock.model.dto.finnhub.CompanyProfile2DTO;
import com.invester.usstock.service.finnhub.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.finnhub.domain}")
    private String domain;

    @Value("${api.finnhub.base-url}")
    private String baseUrl;

    @Value("${api.finnhub.endpoints.stock.profile2}")
    private String companyProfile2Endpoint;
    
    @Value("${api.finnhub.token}")
    private String token;

    @Override
    public CompanyProfile2DTO getCompanyProfile(String symbol) {
        String url = UriComponentsBuilder.newInstance() //
            .scheme("https")
            .host(domain)
            .pathSegment(baseUrl)
            .path(companyProfile2Endpoint)
            .queryParam("symbol", symbol)
            .queryParam("token", token)
            .build()
            .toUriString();

        try {
            CompanyProfile2DTO profile = restTemplate.getForObject(url, CompanyProfile2DTO.class);
            return profile;
        } catch (RestClientException e) {
            System.out.println("Error");
        }
        return null;
    }
    
}
