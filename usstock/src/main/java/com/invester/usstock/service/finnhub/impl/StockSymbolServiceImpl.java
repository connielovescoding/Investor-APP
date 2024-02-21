package com.invester.usstock.service.finnhub.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.invester.usstock.entity.StockSymbol;
import com.invester.usstock.model.dto.finnhub.StockSymbolDTO;
import com.invester.usstock.model.mapper.FinnhubMapper;
import com.invester.usstock.repository.StockSymbolRepo;
import com.invester.usstock.service.finnhub.StockSymbolService;

@Service
public class StockSymbolServiceImpl implements StockSymbolService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FinnhubMapper finnhubMapper;

    @Autowired
    private StockSymbolRepo stockSymbolRepo;

    @Value("${api.finnhub.domain}")
    private String domain;

    @Value("${api.finnhub.base-url}")
    private String baseUrl;

    @Value("${api.finnhub.endpoints.stock.symbol}")
    private String symbolEndpoint;
    
    @Value("${api.finnhub.token}")
    private String token;
    
    @Override
    public List<StockSymbolDTO> getAllSymbols() {
        String url = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .pathSegment(baseUrl)
            .path(symbolEndpoint)
            .queryParam("exchange", "US")
            .queryParam("token", token)
            .build()
            .toUriString();
        
        StockSymbolDTO[] symbols = restTemplate.getForObject(url, StockSymbolDTO[].class);
        return Arrays.asList(symbols);
    }

    @Override
    public List<StockSymbol> save(List<StockSymbolDTO> symbols) {
        List<StockSymbol> stockSymbols = symbols.stream() //
            .filter(s -> "Common Stock".equals(s.getType())) //
            .map(s -> finnhubMapper.map(s)) //
            .collect(Collectors.toList());
        return stockSymbolRepo.saveAll(stockSymbols);
    }

}
