package com.invester.usstock.service.finnhub;

import java.util.List;
import com.invester.usstock.entity.StockSymbol;
import com.invester.usstock.model.dto.finnhub.SymbolDTO;

public interface StockSymbolService {
    
    List<SymbolDTO> getAllSymbols();

    List<StockSymbol> save(List<SymbolDTO> symbols);

}
