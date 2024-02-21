package com.invester.usstock.service.finnhub;

import java.util.List;
import com.invester.usstock.entity.StockSymbol;
import com.invester.usstock.model.dto.finnhub.StockSymbolDTO;

public interface StockSymbolService {
    
    List<StockSymbolDTO> getAllSymbols();

    List<StockSymbol> save(List<StockSymbolDTO> symbols);

}
