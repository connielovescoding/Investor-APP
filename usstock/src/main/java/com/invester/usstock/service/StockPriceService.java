package com.invester.usstock.service;

import java.util.List;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;

public interface StockPriceService {
    
    DailyPriceDTO getDailyPrice(String symbol);

    List<StockPriceDaily> getStockPriceDaily(DailyPriceDTO dailyPriceDTO);
    
}
