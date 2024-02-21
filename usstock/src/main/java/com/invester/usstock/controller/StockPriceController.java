package com.invester.usstock.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;
import com.invester.usstock.model.dto.finnhub.StockPriceRealTimeDTO;
import com.invester.usstock.model.mapper.AlphavantageMapper;
import com.invester.usstock.repository.StockPriceDailyRepo;
import com.invester.usstock.service.StockPriceService;
import com.invester.usstock.service.finnhub.StockPriceRealTimeService;

@RestController
@RequestMapping(value = "/investor")
public class StockPriceController {
    
    @Autowired
    private StockPriceService stockPriceService;

    @Autowired
    private StockPriceDailyRepo StockPriceDailyRepo;

    @Autowired
    private StockPriceRealTimeService stockPriceRealTimeService;

    @GetMapping("/dailyprice/{symbol}")
    public ResponseEntity<DailyPriceDTO> getDailyPrice(@PathVariable String symbol) {
        return ResponseEntity.ok(stockPriceService.getDailyPrice(symbol));
    }

    @GetMapping("/stockprice")
    public ResponseEntity<List<StockPriceDaily>> getStockPriceDaily(@RequestBody DailyPriceDTO dailyPriceDTO) {
        return ResponseEntity.ok(stockPriceService.getStockPriceDaily(dailyPriceDTO));
    }

    @GetMapping("/quote/{symbol}")
    public ResponseEntity<StockPriceRealTimeDTO> getQuote(@PathVariable String symbol) {
        return ResponseEntity.ok(stockPriceRealTimeService.getQuote(symbol));
    }

}
