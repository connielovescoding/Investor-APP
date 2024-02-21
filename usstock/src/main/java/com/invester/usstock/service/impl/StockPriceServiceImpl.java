package com.invester.usstock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;
import com.invester.usstock.model.mapper.AlphavantageMapper;
import com.invester.usstock.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AlphavantageMapper alphavantageMapper;

    @Value("${api.alphavantage.domain}")
    private String domain;

    @Value("${api.alphavantage.apikey}")
    private String apiKey;

    @Value("${api.alphavantage.endpoints.stockprice.query}")
    private String query;

    public DailyPriceDTO getDailyPrice(String symbol) {
        String url = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(domain)
            .path(query)
            .queryParam("function", "TIME_SERIES_DAILY")
            .queryParam("symbol", symbol)
            .queryParam("outputsize", "full")
            .queryParam("apikey", apiKey)
            .build()
            .toUriString();

        return restTemplate.getForObject(url, DailyPriceDTO.class);
    }

    @Override
    public List<StockPriceDaily> getStockPriceDaily(DailyPriceDTO dailyPriceDTO) {
        return alphavantageMapper.map(dailyPriceDTO);
    }
}
