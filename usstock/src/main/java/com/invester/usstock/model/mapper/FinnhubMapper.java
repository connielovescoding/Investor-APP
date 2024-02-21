package com.invester.usstock.model.mapper;

import org.springframework.stereotype.Component;
import com.invester.usstock.entity.StockSymbol;
import com.invester.usstock.model.dto.finnhub.StockSymbolDTO;

@Component
public class FinnhubMapper {

    public StockSymbol map(StockSymbolDTO symbol) {
        return StockSymbol.builder() //
            .symbol(symbol.getSymbol()) //
            .build();
    }

}
