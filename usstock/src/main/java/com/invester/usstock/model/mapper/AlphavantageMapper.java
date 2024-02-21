package com.invester.usstock.model.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.invester.usstock.entity.StockPriceDaily;
import com.invester.usstock.model.dto.alphavantage.DailyPriceDTO;

@Component
public class AlphavantageMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<StockPriceDaily> map(DailyPriceDTO dailyPriceDTO) {
        List<StockPriceDaily> stockPrices = new ArrayList<>();

        if (dailyPriceDTO == null || dailyPriceDTO.getTimeSeriesDaily() == null) {
            return stockPrices;
        }

        // String symbol = dailyPriceDTO.getMetaData().getSymbol();
        Map<String, DailyPriceDTO.DailyStockData> timeSeriesDaily = dailyPriceDTO.getTimeSeriesDaily();

        for (Map.Entry<String, DailyPriceDTO.DailyStockData> entry : timeSeriesDaily.entrySet()) {
            String date = entry.getKey();
            DailyPriceDTO.DailyStockData dailyData = entry.getValue();

            StockPriceDaily stockPrice = StockPriceDaily.builder()
                    .date(LocalDate.parse(date, DATE_FORMATTER))
                    .open(dailyData.getOpen())
                    .high(dailyData.getHigh())
                    .low(dailyData.getLow())
                    .close(dailyData.getClose())
                    .volume(dailyData.getVolume())
                    .build();

            stockPrices.add(stockPrice);
        }

        return stockPrices;
    }

}