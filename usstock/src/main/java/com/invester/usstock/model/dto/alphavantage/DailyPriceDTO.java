package com.invester.usstock.model.dto.alphavantage;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class DailyPriceDTO {
    
    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (Daily)")
    private Map<String, DailyStockData> timeSeriesDaily;

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    public static class MetaData {
        @JsonProperty("1. Information")
        private String information;

        @JsonProperty("2. Symbol")
        private String symbol;

        @JsonProperty("3. Last Refreshed")
        private String lastRefreshed;

        @JsonProperty("4. Output Size")
        private String outputSize;

        @JsonProperty("5. Time Zone")
        private String timeZone;

    }

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    public static class DailyStockData {
        @JsonProperty("1. open")
        private Double open;

        @JsonProperty("2. high")
        private Double high;

        @JsonProperty("3. low")
        private Double low;

        @JsonProperty("4. close")
        private Double close;

        @JsonProperty("5. volume")
        private Long volume;

    }
}
