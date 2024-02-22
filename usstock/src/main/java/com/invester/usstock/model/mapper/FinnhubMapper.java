package com.invester.usstock.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.invester.usstock.entity.Stock;
import com.invester.usstock.entity.StockPriceRealtime;
import com.invester.usstock.entity.StockSymbol;
import com.invester.usstock.model.dto.finnhub.CompanyProfile2DTO;
import com.invester.usstock.model.dto.finnhub.QuoteDTO;
import com.invester.usstock.model.dto.finnhub.SymbolDTO;
import com.invester.usstock.model.dto.webapp.CompanyProfileDTO;
import com.invester.usstock.model.dto.webapp.StockInfoDTO;

@Component
public class FinnhubMapper {

    @Autowired
    ModelMapper modelMapper;

    public StockInfoDTO map(CompanyProfile2DTO companyProfile, QuoteDTO quote) {
        return StockInfoDTO.builder() //
            .companyProfile(modelMapper.map(companyProfile, CompanyProfileDTO.class)) //
            .currentPrice(quote.getCurrentPrice()) //
            .dayHigh(quote.getDayHigh()) //
            .dayLow(quote.getDayLow()) //
            .dayOpen(quote.getDayOpen()) //
            .prevDayClose(quote.getPreDayClose()) //
            .build();
    }

    public Stock map(CompanyProfile2DTO profile) {
        return Stock.builder() //
            .country(profile.getCountry()) //
            .companyName(profile.getCompanyName()) //
            .ipoDate(profile.getIpoDate()) //
            .logo(profile.getLogo()) //
            .marketCap(profile.getMarketCap()) //
            .currency(profile.getCurrency()) //
            .build();
    }

    public StockPriceRealtime map(QuoteDTO quote) {
        return StockPriceRealtime.builder() //
            .currentPrice(quote.getCurrentPrice()) //
            .dayHigh(quote.getDayHigh()) //
            .dayLow(quote.getDayLow()) //
            .dayOpen(quote.getDayOpen()) //
            .prevDayClose(quote.getPreDayClose()) //
            .build();
    }

    public StockSymbol map(SymbolDTO symbol) {
        return StockSymbol.builder() //
            .symbol(symbol.getSymbol()) //
            .build();
    }

}
