package com.invester.usstock.service.finnhub;

import com.invester.usstock.model.dto.finnhub.CompanyProfile2DTO;

public interface CompanyService {

    CompanyProfile2DTO getCompanyProfile(String symbol);
    
}
