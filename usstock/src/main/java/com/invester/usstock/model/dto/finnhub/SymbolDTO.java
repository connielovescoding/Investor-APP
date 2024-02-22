package com.invester.usstock.model.dto.finnhub;

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
public class SymbolDTO {
    
    private String currency;
    
    @JsonProperty(value = "description")
    private String desc;

    private String displaySymbol;

    @JsonProperty(value = "figi")
    private String figiIdentifier;

    @JsonProperty(value = "mic")
    private String exchangeMic;

    private String symbol;

    private String type;
}
