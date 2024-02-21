// package com.invester.usstock.config;

// import java.util.List;
// import java.util.stream.Collectors;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import com.invester.usstock.entity.StockPriceDaily;
// import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;
// import com.invester.usstock.model.dto.finnhub.StockSymbolDTO;
// import com.invester.usstock.model.mapper.AlphavantageMapper;
// import com.invester.usstock.repository.StockPriceDailyRepo;
// import com.invester.usstock.repository.StockSymbolRepo;
// import com.invester.usstock.service.StockPriceService;
// import com.invester.usstock.service.finnhub.StockSymbolService;

// @Component
// public class AppStartRunner implements CommandLineRunner {
    
//     // private static final Logger logger = LoggerFactory.getLogger(AppStartRunner.class);

//     public static final List<String> mamaaSymbols = List.of("META", "AAPL", "MSFT", "AMZN", "GOOGL");

//     @Autowired
//     AlphavantageMapper alphavantageMapper;

//     @Autowired
//     private StockSymbolService stockSymbolService;

//     @Autowired
//     private StockSymbolRepo stockSymbolRepo;

//     @Autowired
//     private StockPriceService stockPriceService;

//     @Autowired
//     private StockPriceDailyRepo StockPriceDailyRepo;

//     @Override
//     public void run(String... args) {

//         stockSymbolRepo.deleteAll();

//          List<StockSymbolDTO> symbols = stockSymbolService.getAllSymbols().stream() //
//             .filter(symbol -> mamaaSymbols.contains(symbol.getSymbol())) //
//             .collect(Collectors.toList());

//         stockSymbolService.save(symbols).stream()
//             .forEach(symbol -> {
//                 try {
//                     DailyPriceDTO dailyPrice = stockPriceService.getDailyPrice(symbol.getSymbol());
//                     List<StockPriceDaily> stockPrices = alphavantageMapper.map(dailyPrice);
//                     stockPrices.stream()
//                         .forEach(stockPrice -> {
//                             stockPrice.setStockSymbol(symbol);
//                         });
//                     StockPriceDailyRepo.saveAll(stockPrices);
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                     // logger.info("ERROR: symbol= " + symbol.getSymbol());
//                 }
//             });
        
//     }
// }

// // logger.info("MAMAA symbols are inserted into DB. Total: " + symbols.size() + "symbols");