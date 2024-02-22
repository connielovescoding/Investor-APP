package com.invester.usstock.service.alphavantage;

import java.util.List;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;

public interface StockPriceDailyService {
    
    DailyPriceDTO getDailyPrice(String symbol);

    List<StockPriceDaily> getStockPriceDaily(DailyPriceDTO dailyPriceDTO);
    
}
