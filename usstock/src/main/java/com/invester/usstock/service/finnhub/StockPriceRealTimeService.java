package com.invester.usstock.service.finnhub;

import com.invester.usstock.model.dto.finnhub.StockPriceRealTimeDTO;

public interface StockPriceRealTimeService {

    StockPriceRealTimeDTO getQuote(String symbol);
    
}
