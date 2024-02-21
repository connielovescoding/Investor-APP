package com.invester.usstock.model.dto.finnhub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockPriceRealTimeDTO {

    @JsonProperty(value = "c")
    private double currentPrice;

    @JsonProperty(value = "h")
    private double dayHigh;

    @JsonProperty(value = "l")
    private double dayLow;

    @JsonProperty(value = "o")
    private double dayOpen;

    @JsonProperty(value = "pc")
    private double preDayClose;

    @JsonProperty(value = "t")
    private long unixtime;
    
}
