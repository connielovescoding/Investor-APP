package com.invester.usstock.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;
import com.invester.usstock.model.dto.finnhub.QuoteDTO;
import com.invester.usstock.service.alphavantage.StockPriceDailyService;
import com.invester.usstock.service.finnhub.StockPriceRealtimeService;

@RestController
@RequestMapping(value = "/investor")
public class StockPriceController {
    
    @Autowired
    private StockPriceDailyService stockPriceService;

    @Autowired
    private StockPriceRealtimeService stockPriceRealTimeService;

    @GetMapping("/dailyprice/{symbol}")
    public ResponseEntity<DailyPriceDTO> getDailyPrice(@PathVariable String symbol) {
        return ResponseEntity.ok(stockPriceService.getDailyPrice(symbol));
    }

    @GetMapping("/stockprice")
    public ResponseEntity<List<StockPriceDaily>> getStockPriceDaily(@RequestBody DailyPriceDTO dailyPriceDTO) {
        return ResponseEntity.ok(stockPriceService.getStockPriceDaily(dailyPriceDTO));
    }

    @GetMapping("/quote/{symbol}")
    public ResponseEntity<QuoteDTO> getQuote(@PathVariable String symbol) {
        return ResponseEntity.ok(stockPriceRealTimeService.getQuote(symbol));
    }

}
