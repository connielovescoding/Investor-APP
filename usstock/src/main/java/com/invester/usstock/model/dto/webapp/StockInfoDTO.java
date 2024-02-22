package com.invester.usstock.model.dto.webapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StockInfoDTO {

    private CompanyProfileDTO companyProfile;

    private double currentPrice;
    
    private double dayHigh;
    
    private double dayLow;
    
    private double dayOpen;
    
    private double prevDayClose;
    
}
