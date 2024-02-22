package com.invester.usstock.config;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.invester.usstock.entity.Stock;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.entity.StockPriceRealtime;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;
import com.invester.usstock.model.dto.finnhub.CompanyProfile2DTO;
import com.invester.usstock.model.dto.finnhub.QuoteDTO;
import com.invester.usstock.model.dto.finnhub.SymbolDTO;
import com.invester.usstock.model.mapper.AlphavantageMapper;
import com.invester.usstock.model.mapper.FinnhubMapper;
import com.invester.usstock.repository.StockPriceDailyRepo;
import com.invester.usstock.repository.StockPriceRealtimeRepo;
import com.invester.usstock.repository.StockRepo;
import com.invester.usstock.repository.StockSymbolRepo;
import com.invester.usstock.service.alphavantage.StockPriceDailyService;
import com.invester.usstock.service.finnhub.CompanyService;
import com.invester.usstock.service.finnhub.StockPriceRealtimeService;
import com.invester.usstock.service.finnhub.StockSymbolService;

@Component
public class AppStartRunner implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(AppStartRunner.class);

    public static final List<String> mamaaSymbols = List.of("META", "AAPL", "MSFT", "AMZN", "GOOGL");

    @Autowired
    AlphavantageMapper alphavantageMapper;

    @Autowired
    FinnhubMapper finnhubMapper;

    @Autowired
    private StockSymbolService stockSymbolService;

    @Autowired
    private StockSymbolRepo stockSymbolRepo;

    @Autowired
    private StockPriceDailyService stockPriceDailyService;

    @Autowired
    private StockPriceDailyRepo stockPriceDailyRepo;

    @Autowired
    private StockPriceRealtimeRepo stockPriceRealtimeRepo;

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StockPriceRealtimeService stockPriceRealtimeService;

    @Override
    public void run(String... args) {

        stockPriceDailyRepo.deleteAll();
        stockPriceRealtimeRepo.deleteAll();
        stockRepo.deleteAll();
        stockSymbolRepo.deleteAll();

         List<SymbolDTO> symbols = stockSymbolService.getAllSymbols().stream() //
            .filter(symbol -> mamaaSymbols.contains(symbol.getSymbol())) //
            .collect(Collectors.toList());

        stockSymbolService.save(symbols).stream()
            .forEach(symbol -> {
                try {

                    CompanyProfile2DTO companyProfile2DTO = companyService.getCompanyProfile(symbol.getSymbol());
                    Stock stock = finnhubMapper.map(companyProfile2DTO);
                    stock.setStockSymbol(symbol);
                    Stock storedStock = stockRepo.save(stock);

                    QuoteDTO quoteDTO = stockPriceRealtimeService.getQuote(symbol.getSymbol());
                    StockPriceRealtime stockPriceRealtime = finnhubMapper.map(quoteDTO);
                    stockPriceRealtime.setStock(storedStock);
                    stockPriceRealtimeRepo.save(stockPriceRealtime);

                    DailyPriceDTO dailyPrice = stockPriceDailyService.getDailyPrice(symbol.getSymbol());
                    List<StockPriceDaily> stockPrices = alphavantageMapper.map(dailyPrice);
                    stockPrices.stream()
                        .forEach(stockPrice -> {
                            stockPrice.setStockSymbol(symbol);
                        });
                    stockPriceDailyRepo.saveAll(stockPrices);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.info("ERROR: symbol= " + symbol.getSymbol());
                }
            });
        
    }
}

// logger.info("MAMAA symbols are inserted into DB. Total: " + symbols.size() + "symbols");